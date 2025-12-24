package com.brickbase.platform.dto.requestDTO;

import com.brickbase.platform.enums.ProductStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    @Size(min = 10, max = 500)
    private String description;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    @PositiveOrZero
    private Integer quantity;

    @NotNull
    private ProductStatus status;

    @NotBlank(message = "Category ID is required")
    private String categoryId;

    @NotBlank(message = "Worker ID is required")
    private String workerId;

    @NotBlank
    private String location;
}