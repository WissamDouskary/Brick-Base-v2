package com.brickbase.platform.repository;

import com.brickbase.platform.model.Role;
import com.brickbase.platform.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(RoleName name);
}
