package com.brickbase.security.service;

import com.brickbase.platform.dto.requestDTO.LoginRequest;
import com.brickbase.platform.dto.requestDTO.UserRequestDTO;
import com.brickbase.platform.dto.responseDTO.LoginResponse;
import com.brickbase.platform.dto.responseDTO.UserResponseDTO;
import com.brickbase.platform.enums.RoleName;
import com.brickbase.platform.exception.BusinessException;
import com.brickbase.platform.exception.ResourceNotFoundException;
import com.brickbase.platform.mapper.UserMapper;
import com.brickbase.platform.model.Role;
import com.brickbase.platform.model.User;
import com.brickbase.platform.model.WorkerProfile;
import com.brickbase.platform.repository.RoleRepository;
import com.brickbase.platform.repository.UserRepository;
import com.brickbase.platform.repository.WorkerProfileRepository;
import com.brickbase.security.config.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;


@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final WorkerProfileRepository profileRepository;
    private final AuthenticationManager authenticationManager;

    public UserResponseDTO saveUser(UserRequestDTO dto) {
        RoleName roleName = switch (dto.getRole().toUpperCase()) {
            case "WORKER" -> RoleName.ROLE_WORKER;
            case "CLIENT" -> RoleName.ROLE_CLIENT;
            default -> throw new BusinessException("Invalid role");
        };

        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        dto.setRole(role.getName().name());

        User user = userMapper.toEntity(dto);
        user.setRole(role);
        user.setPassword(SecurityConfig.passwordEncoder().encode(dto.getPassword()));

        if (roleName == RoleName.ROLE_WORKER) {
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }

        User savedUser = userRepository.save(user);

        if (roleName == RoleName.ROLE_WORKER) {
            WorkerProfile profile = new WorkerProfile();
            profile.setUser(savedUser);
            profileRepository.save(profile);
        }

        return userMapper.toResponse(savedUser);
    }
}
