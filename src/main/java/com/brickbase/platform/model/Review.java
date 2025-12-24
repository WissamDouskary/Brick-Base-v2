package com.brickbase.platform.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
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
