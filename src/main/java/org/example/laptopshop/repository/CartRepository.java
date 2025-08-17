package org.example.laptopshop.repository;

import org.example.laptopshop.entity.Cart;
import org.example.laptopshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
