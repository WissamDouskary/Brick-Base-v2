package com.brickbase.platform.model;

import com.brickbase.platform.enums.JobTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "worker_profiles")
@Getter
@Setter
@NoArgsConstructor
public class WorkerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    private User user;

    private String skills;
    private Double pricePerDay;
    private String description;

    @Enumerated(EnumType.STRING)
    private JobTypes jobTitle;
    private String category;

    private boolean available = true;
}