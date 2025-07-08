package org.example.laptopshop.repository;

import java.util.Optional;

import org.example.laptopshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
