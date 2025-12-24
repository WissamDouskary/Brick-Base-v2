package com.brickbase.platform.dto.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDTO {
    private String id;
    private String message;
    private boolean read;
    private String userId;
    private LocalDateTime createdAt;
}
