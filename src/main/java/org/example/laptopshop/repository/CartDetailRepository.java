package org.example.laptopshop.repository;

import org.example.laptopshop.entity.Cart;
import org.example.laptopshop.entity.CartDetail;
import org.example.laptopshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    boolean existsByCartAndProduct(Cart cart, Product product);

    CartDetail findByCartAndProduct(Cart cart, Product product);
}
