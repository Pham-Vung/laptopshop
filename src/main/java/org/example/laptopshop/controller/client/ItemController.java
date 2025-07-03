package org.example.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ItemController {

    @GetMapping("/{id}")
    public String getProductPage(@PathVariable long id) {
        return "client/product/detail";
    }
}
