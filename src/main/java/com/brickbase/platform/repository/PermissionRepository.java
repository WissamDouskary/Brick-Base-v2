package com.brickbase.platform.repository;

import com.brickbase.platform.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
    Permission findByName(String name);
}
