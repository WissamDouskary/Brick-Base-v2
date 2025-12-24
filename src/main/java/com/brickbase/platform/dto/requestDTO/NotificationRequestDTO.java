package com.brickbase.platform.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotificationRequestDTO {

    @NotBlank(message = "Message is required")
    private String message;

    @NotBlank(message = "User ID is required")
    private String userId;
}
