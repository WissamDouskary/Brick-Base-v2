package com.brickbase.platform.config;

import com.brickbase.platform.exception.ResourceNotFoundException;
import com.brickbase.platform.model.Permission;
import com.brickbase.platform.model.Role;
import com.brickbase.platform.enums.RoleName;
import com.brickbase.platform.repository.PermissionRepository;
import com.brickbase.platform.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(PermissionRepository permissionRepository, RoleRepository roleRepository) {
        return args -> {

            String[] permissionsArray = {
                    "USER_READ", "USER_WRITE", "USER_DELETE",
                    "PRODUCT_READ", "PRODUCT_WRITE", "PRODUCT_DELETE",
                    "ORDER_READ", "ORDER_WRITE", "ORDER_DELETE",
                    "WORKER_READ", "WORKER_WRITE", "WORKER_DELETE",
                    "REVIEW_READ", "REVIEW_WRITE", "REVIEW_DELETE",
                    "FAVORITE_READ", "FAVORITE_WRITE",
                    "NOTIFICATION_READ", "NOTIFICATION_WRITE",
                    "DASHBOARD_VIEW"
            };

            Set<Permission> allPermissions = new HashSet<>();
            for (String permName : permissionsArray) {
                Permission permission = permissionRepository.findByName(permName);
                if (permission == null) {
                    permission = new Permission();
                    permission.setName(permName);
                    permissionRepository.save(permission);
                }
                allPermissions.add(permission);
            }

            createRoleIfNotExists(roleRepository, RoleName.ROLE_ADMIN, allPermissions);

            Set<Permission> workerPermissions = new HashSet<>();
            for (String perm : new String[] {
                    "PRODUCT_READ", "PRODUCT_WRITE", "PRODUCT_DELETE",
                    "ORDER_READ", "ORDER_WRITE",
                    "WORKER_READ", "WORKER_WRITE",
                    "REVIEW_READ", "REVIEW_WRITE",
                    "FAVORITE_READ", "FAVORITE_WRITE"
            }) {
                workerPermissions.add(permissionRepository.findByName(perm));
            }
            createRoleIfNotExists(roleRepository, RoleName.ROLE_WORKER, workerPermissions);

            Set<Permission> clientPermissions = new HashSet<>();
            for (String perm : new String[] {
                    "PRODUCT_READ",
                    "ORDER_READ", "ORDER_WRITE",
                    "REVIEW_READ", "REVIEW_WRITE",
                    "FAVORITE_READ", "FAVORITE_WRITE"
            }) {
                clientPermissions.add(permissionRepository.findByName(perm));
            }
            createRoleIfNotExists(roleRepository, RoleName.ROLE_CLIENT, clientPermissions);
        };
    }

    private void createRoleIfNotExists(RoleRepository roleRepository, RoleName roleName, Set<Permission> permissions) {
        Role role = roleRepository.findByName(roleName)
                .orElse(null);
        if (role == null) {
            role = new Role();
            role.setName(roleName);
            role.setPermissions(permissions);
            roleRepository.save(role);
        }
    }
}
