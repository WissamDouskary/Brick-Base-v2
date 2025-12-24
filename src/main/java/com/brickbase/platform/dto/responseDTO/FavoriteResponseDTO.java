package com.brickbase.platform.dto.responseDTO;

import lombok.Data;

@Data
public class FavoriteResponseDTO {
    private String id;
    private String userId;
    private String productId;
    private String workerId;
}
