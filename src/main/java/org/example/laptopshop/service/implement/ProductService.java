package org.example.laptopshop.service.implement;

import lombok.RequiredArgsConstructor;
import org.example.laptopshop.entity.Cart;
import org.example.laptopshop.entity.CartDetail;
import org.example.laptopshop.entity.Product;
import org.example.laptopshop.entity.User;
import org.example.laptopshop.exception.ProductNotFoundException;
import org.example.laptopshop.repository.CartDetailRepository;
import org.example.laptopshop.repository.CartRepository;
import org.example.laptopshop.repository.ProductRepository;
import org.example.laptopshop.service.interfaces.IProductService;
import org.example.laptopshop.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final IUserService userService;

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

    @Override
    public void handleAddProductToCart(long productId, String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            Cart cart = cartRepository.findByUser(user);
            if (cart == null) {
                cart = cartRepository.save(Cart.builder()
                        .user(user)
                        .sum(1)
                        .build());
            }
            // find product by id
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException("Product not found"));
            cartDetailRepository.save(CartDetail.builder()
                    .cart(cart)
                    .price(product.getPrice())
                    .product(product)
                    .quantity(1)
                    .build());
        }
    }
}
