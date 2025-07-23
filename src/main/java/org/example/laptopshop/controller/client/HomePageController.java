package org.example.laptopshop.controller.client;

import java.util.List;

import jakarta.validation.Valid;

import org.example.laptopshop.DTO.request.RegisterRequest;
import org.example.laptopshop.entity.Product;
import org.example.laptopshop.entity.User;
import org.example.laptopshop.mapper.UserMapper;
import org.example.laptopshop.service.interfaces.IProductService;
import org.example.laptopshop.service.interfaces.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomePageController {
    private final IProductService productService;
    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @GetMapping
    public String getHomePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "client/homepage/show";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterRequest());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(
            @ModelAttribute("registerUser") @Valid RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "client/auth/register";
        }

        User user = userMapper.toUser(request);

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(userService.getRoleByName("USER"));

        userService.handleSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "client/auth/login";
    }

    @GetMapping("/access-deny")
    public String getAccessDeniedPage(Model model) {
        return "client/auth/access-deny";
    }
}
