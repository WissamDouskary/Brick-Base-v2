package com.brickbase.platform.model;

import com.brickbase.platform.enums.ProductStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;
    private Double price;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User worker;

    private String location;

    private LocalDateTime createdAt;
}
