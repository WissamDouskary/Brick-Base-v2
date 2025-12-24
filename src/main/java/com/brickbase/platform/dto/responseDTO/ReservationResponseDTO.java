package com.brickbase.platform.dto.responseDTO;

import com.brickbase.platform.enums.ReservationStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservationResponseDTO {
    private String id;
    private String clientId;
    private String workerId;
    private LocalDate reservationDate;
    private ReservationStatus status;
    private LocalDateTime createdAt;
}

