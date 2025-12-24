package com.brickbase.platform.dto.requestDTO;

import com.brickbase.platform.enums.ReservationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequestDTO {

    @NotBlank
    private String clientId;

    @NotBlank
    private String workerId;

    @NotNull
    private LocalDate reservationDate;

    @NotNull
    private ReservationStatus status;
}

