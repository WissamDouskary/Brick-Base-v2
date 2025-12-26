package com.brickbase.platform.repository;

import com.brickbase.platform.model.User;
import com.brickbase.platform.model.WorkerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkerProfileRepository extends JpaRepository<WorkerProfile, String> {
    Optional<WorkerProfile> findByUser(User user);
}
