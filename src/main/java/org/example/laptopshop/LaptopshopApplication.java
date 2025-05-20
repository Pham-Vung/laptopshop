package org.example.laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaptopshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaptopshopApplication.class, args);
//        ApplicationContext context = SpringApplication.run(LaptopshopApplication.class, args);
//        for (String name : context.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
    }

}
