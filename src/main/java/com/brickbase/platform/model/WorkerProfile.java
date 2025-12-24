package com.brickbase.platform.model;

import jakarta.persistence.*;

@Entity
@Table(name = "worker_profiles")
public class WorkerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    private User user;

    private String skills;
    private Double pricePerDay;
    private String description;

    private boolean available = true;
}