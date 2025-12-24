package com.brickbase.platform.dto.requestDTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ReviewRequestDTO {

    @Min(1)
    @Max(5)
    private int rating;

    @NotBlank
    @Size(min = 5, max = 300)
    private String comment;

    @NotBlank
    private String authorId;

    @NotBlank
    private String productId;

    private String workerId;
}

