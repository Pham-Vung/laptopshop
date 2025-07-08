package org.example.laptopshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotNull
    @DecimalMin(value = "0", message = "Price must be greater than 0", inclusive = false)
    private double price;

    private String image;

    @NotBlank(message = "Product description details cannot be left blank")
    private String detailDesc;

    @NotBlank(message = "Product short description cannot be left blank")
    private String shortDesc;

    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    private long quantity;

    private long sold;
    private String factory;
    private String target;
}
