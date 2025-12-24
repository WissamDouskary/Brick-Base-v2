package com.brickbase.platform.dto.responseDTO;

import lombok.Data;

@Data
public class WorkerProfileResponseDTO {
    private String id;
    private String userId;
    private String skills;
    private Double pricePerDay;
    private String description;
    private boolean available;
}
