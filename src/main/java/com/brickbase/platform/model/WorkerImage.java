package com.brickbase.platform.model;

import jakarta.persistence.*;

@Entity
@Table(name = "worker_image")
public class WorkerImage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String image_path;

    @ManyToOne
    private User worker;
}
