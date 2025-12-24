package com.brickbase.platform.dto.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewResponseDTO {
    private String id;
    private int rating;
    private String comment;
    private String authorId;
    private String productId;
    private String workerId;
    private LocalDateTime createdAt;
}
