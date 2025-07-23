package org.example.laptopshop.config;

import jakarta.servlet.DispatcherType;

import org.example.laptopshop.service.implement.CustomUserDetailsService;
import org.example.laptopshop.service.implement.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import io.micrometer.core.instrument.binder.logging.LogbackMetrics;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final String[] PUBLIC_URLS = {
        "/", "/login", "/client/**", "/css/**", "/js/**", "/images/**", "/register", "/product/**"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return new CustomUserDetailsService(userService);
    }

    @Bean
    public DaoAuthenticationProvider authProvider(
            PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        //        authProvider.setHideUserNotFoundExceptions(false);
        return authProvider;
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomSuccessHandler();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, LogbackMetrics logbackMetrics) throws Exception {
        http.authorizeHttpRequests(auth -> auth.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.INCLUDE)
                        .permitAll()
                        .requestMatchers(PUBLIC_URLS)
                        .permitAll() // truy cap ma k can xac thuc
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login?error")
                        .successHandler(authenticationSuccessHandler())
                        .permitAll())
                .exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/access-deny"));

        return http.build();
    }
}
