package com.brickbase.platform.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String message;

    private boolean read = false;

    @ManyToOne
    private User user;

    private LocalDateTime createdAt;
}

