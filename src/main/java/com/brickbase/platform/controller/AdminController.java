package com.brickbase.platform.controller;

import com.brickbase.platform.dto.ApiResponse;
import com.brickbase.platform.dto.responseDTO.WorkerProfileResponseDTO;
import com.brickbase.platform.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final AdminService adminService;

    @PutMapping("/approve-worker/{userId}")
    public ResponseEntity<ApiResponse> approveWorker(@PathVariable String userId) {
        adminService.approveWorker(userId);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .httpStatus(HttpStatus.OK)
                        .message("You Have update Your information")
                        .build()
        );
    }
}
