package com.brickbase.platform.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "email required")
    private String email;

    @NotBlank(message = "password required")
    private String password;
}
