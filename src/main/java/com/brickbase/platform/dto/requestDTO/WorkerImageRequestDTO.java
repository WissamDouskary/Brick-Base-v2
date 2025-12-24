package com.brickbase.platform.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WorkerImageRequestDTO {

    @NotBlank
    private String imagePath;

    @NotBlank
    private String workerId;
}
