package com.brickbase.platform.dto.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
    private String role;
    private LocalDateTime createdAt;
}

