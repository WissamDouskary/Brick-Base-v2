package com.brickbase.platform.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int rating;
    private String comment;

    @ManyToOne
    private User author;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User worker;

    private LocalDateTime createdAt;
}
