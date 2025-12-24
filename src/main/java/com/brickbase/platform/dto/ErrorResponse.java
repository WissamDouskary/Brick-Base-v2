package com.brickbase.platform.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String title;
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
    private List<String> errors;
}

