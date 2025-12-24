package com.brickbase.platform.dto.responseDTO;

import com.brickbase.platform.enums.ProductStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponseDTO {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private ProductStatus status;
    private String categoryName;
    private String workerId;
    private String location;
    private LocalDateTime createdAt;
}

