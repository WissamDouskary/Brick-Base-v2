package com.brickbase.platform.controller;

import com.brickbase.platform.dto.ApiResponse;
import com.brickbase.platform.dto.requestDTO.WorkerProfileRequestDTO;
import com.brickbase.platform.dto.responseDTO.WorkerProfileResponseDTO;
import com.brickbase.platform.service.WorkerProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
@AllArgsConstructor
public class WorkerProfileController {
    private final WorkerProfileService profileService;

    @PutMapping("/worker-profile")
    @PreAuthorize("hasRole('ROLE_WORKER')")
    public ResponseEntity<ApiResponse<WorkerProfileResponseDTO>> completeProfile(
            @Valid @RequestBody WorkerProfileRequestDTO dto
    ) {
        WorkerProfileResponseDTO workerProfileResponseDTO = profileService.completeProfile(dto);
        return ResponseEntity.ok(
                        ApiResponse.<WorkerProfileResponseDTO>builder()
                                .status(HttpStatus.OK.value())
                                .httpStatus(HttpStatus.OK)
                                .message("You Have update Your information")
                                .data(workerProfileResponseDTO)
                                .build()
                );
    }
}
