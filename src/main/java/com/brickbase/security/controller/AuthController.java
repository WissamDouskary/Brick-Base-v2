package com.brickbase.security.controller;

import com.brickbase.platform.dto.ApiResponse;
import com.brickbase.platform.dto.requestDTO.UserRequestDTO;
import com.brickbase.platform.dto.responseDTO.UserResponseDTO;
import com.brickbase.security.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> register(
            @Valid @RequestBody UserRequestDTO dto
    ){
        UserResponseDTO userResponseDTO = authService.saveUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<UserResponseDTO>builder()
                                .title("CREATED")
                                .status(HttpStatus.CREATED.value())
                                .httpStatus(HttpStatus.CREATED)
                                .message("You have registered successfully")
                                .data(userResponseDTO)
                                .build()
                );
    }
}
