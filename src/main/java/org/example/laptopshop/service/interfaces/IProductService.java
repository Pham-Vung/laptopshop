package org.example.laptopshop.service.interfaces;

import jakarta.servlet.http.HttpSession;
import org.example.laptopshop.entity.Product;

import java.util.List;

public interface IProductService {
    Product creatingProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long id);

    void deleteProductById(long id);

    void handleAddProductToCart(long productId, String email, HttpSession session);
}
