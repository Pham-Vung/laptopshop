package org.example.laptopshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
