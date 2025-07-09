package org.example.laptopshop.controller.client;

import java.util.List;

import org.example.laptopshop.entity.Product;
import org.example.laptopshop.service.interfaces.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomePageController {
    private final IProductService productService;

    @GetMapping
    public String getHomePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "client/homepage/show";
    }
}
