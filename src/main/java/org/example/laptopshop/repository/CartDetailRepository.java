package org.example.laptopshop.repository;

import org.example.laptopshop.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
}
