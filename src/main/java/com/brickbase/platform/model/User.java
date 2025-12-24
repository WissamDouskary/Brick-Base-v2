package com.brickbase.platform.model;

import com.brickbase.platform.enums.JobTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String phone;

    private String location;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    private boolean enabled = true;

    private LocalDateTime createdAt;

    // worker attributes
    private String bio;

    @Enumerated(EnumType.STRING)
    private JobTypes jobTitle;

    private String category;

    private float price;

    @OneToMany(mappedBy = "worker")
    private List<WorkerImage> workerImage;
}
