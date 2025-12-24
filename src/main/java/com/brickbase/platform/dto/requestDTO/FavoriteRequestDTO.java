package com.brickbase.platform.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FavoriteRequestDTO {

    @NotBlank(message = "User ID is required")
    private String userId;

    private String productId;

    private String workerId;
}
