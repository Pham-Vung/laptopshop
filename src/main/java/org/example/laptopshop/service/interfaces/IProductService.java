package org.example.laptopshop.service.interfaces;

import java.util.List;

import org.example.laptopshop.entity.Product;

public interface IProductService {
    Product creatingProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long id);

    void deleteProductById(long id);
}
