package org.example.laptopshop.service.implement;

import java.util.List;

import org.example.laptopshop.entity.Product;
import org.example.laptopshop.exception.ProductNotFoundException;
import org.example.laptopshop.repository.ProductRepository;
import org.example.laptopshop.service.interfaces.IProductService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Override
    public Product creatingProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
