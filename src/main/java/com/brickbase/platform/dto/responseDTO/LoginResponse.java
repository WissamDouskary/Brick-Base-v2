package com.brickbase.platform.dto.responseDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String message;
    private String token;
    private String role;
}
