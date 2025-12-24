package com.brickbase.platform.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "worker_image")
@Getter
@Setter
@NoArgsConstructor
public class WorkerImage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String image_path;

    @ManyToOne
    private User worker;
}
