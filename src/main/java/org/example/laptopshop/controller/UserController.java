package org.example.laptopshop.controller;

import lombok.RequiredArgsConstructor;
import org.example.laptopshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/")
    public String getHomePage() {
        return "hello";
    }
}
