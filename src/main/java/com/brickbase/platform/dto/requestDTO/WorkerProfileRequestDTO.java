package com.brickbase.platform.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class WorkerProfileRequestDTO {

    @NotBlank
    private String userId;

    @NotBlank
    private String skills;

    @Positive
    private Double pricePerDay;

    private String description;
}

