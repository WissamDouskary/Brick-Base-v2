package com.brickbase.security.service;

import com.brickbase.platform.dto.requestDTO.UserRequestDTO;
import com.brickbase.platform.dto.responseDTO.UserResponseDTO;
import com.brickbase.platform.enums.RoleName;
import com.brickbase.platform.exception.BusinessException;
import com.brickbase.platform.exception.ResourceNotFoundException;
import com.brickbase.platform.mapper.UserMapper;
import com.brickbase.platform.model.Role;
import com.brickbase.platform.model.User;
import com.brickbase.platform.repository.RoleRepository;
import com.brickbase.platform.repository.UserRepository;
import com.brickbase.security.config.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    public UserResponseDTO saveUser(UserRequestDTO dto) {
        RoleName roleName;
        if ("WORKER".equalsIgnoreCase(dto.getRole())) {
            roleName = RoleName.ROLE_WORKER;
        } else if ("CLIENT".equalsIgnoreCase(dto.getRole())) {
            roleName = RoleName.ROLE_CLIENT;
        } else {
            throw new BusinessException("Role not found or role not defined!");
        }

        dto.setRole("ROLE_" + dto.getRole());

        User user = userMapper.toEntity(dto);

        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with this name!"));

        user.setRole(role);
        user.setPassword(SecurityConfig.passwordEncoder().encode(dto.getPassword()));

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }
}
