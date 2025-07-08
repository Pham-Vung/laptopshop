package org.example.laptopshop.controller.admin;

import java.util.List;

import jakarta.validation.Valid;

import org.example.laptopshop.entity.Product;
import org.example.laptopshop.service.interfaces.IProductService;
import org.example.laptopshop.service.interfaces.IUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/product")
public class ProductController {
    private final IProductService productService;
    private final IUploadService uploadService;

    @GetMapping
    public String getProduct(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/product/show";
    }

    @GetMapping("/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("/create")
    public String createProductPage(
            @Valid @ModelAttribute("newProduct") Product newProduct,
            BindingResult newProductBindingResult,
            @RequestParam("vincentFile") MultipartFile file) {

        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        String imageProduct = uploadService.handleSaveUploadFile(file, "product");
        newProduct.setImage(imageProduct);

        productService.creatingProduct(newProduct);

        return "redirect:/admin/product";
    }

    @GetMapping("/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("product", productService.getProductById(id));
        return "admin/product/detail";
    }

    @GetMapping("/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Product currentProduct = productService.getProductById(id);
        model.addAttribute("newProduct", currentProduct);
        return "admin/product/update";
    }

    @PostMapping("/update")
    public String postUpdateProduct(
            @ModelAttribute("newProduct") @Valid Product product,
            BindingResult newProductBindingResult,
            @RequestParam("vincentFile") MultipartFile file) {
        if (newProductBindingResult.hasErrors()) {
            return "admin/product/update";
        }

        Product currentProduct = productService.getProductById(product.getId());

        if (currentProduct != null) {
            if (!file.isEmpty()) {
                String img = uploadService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }

            currentProduct.setName(product.getName());
            currentProduct.setPrice(product.getPrice());
            currentProduct.setDetailDesc(product.getDetailDesc());
            currentProduct.setShortDesc(product.getShortDesc());
            currentProduct.setQuantity(product.getQuantity());
            currentProduct.setFactory(product.getFactory());
            currentProduct.setTarget(product.getTarget());

            productService.creatingProduct(currentProduct);
        }

        return "redirect:/admin/product";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newProduct", new Product());
        return "admin/product/delete";
    }

    @PostMapping("/delete")
    public String postDeleteProduct(@ModelAttribute("newProduct") Product product) {
        productService.deleteProductById(product.getId());
        return "redirect:/admin/product";
    }
}
