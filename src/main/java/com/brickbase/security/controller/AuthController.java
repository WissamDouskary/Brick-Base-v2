package com.brickbase.security.controller;

import com.brickbase.platform.dto.ApiResponse;
import com.brickbase.platform.dto.ErrorResponse;
import com.brickbase.platform.dto.requestDTO.LoginRequest;
import com.brickbase.platform.dto.requestDTO.UserRequestDTO;
import com.brickbase.platform.dto.responseDTO.LoginResponse;
import com.brickbase.platform.dto.responseDTO.UserResponseDTO;
import com.brickbase.security.service.AuthService;
import com.brickbase.security.service.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
//    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> register(
            @Valid @RequestBody UserRequestDTO dto
    ){
        UserResponseDTO userResponseDTO = authService.saveUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<UserResponseDTO>builder()
                                .status(HttpStatus.CREATED.value())
                                .httpStatus(HttpStatus.CREATED)
                                .message("You have registered successfully")
                                .data(userResponseDTO)
                                .build()
                );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequest request
    ){

        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        }
        catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(
                            ErrorResponse.builder()
                                    .httpStatus(HttpStatus.UNAUTHORIZED)
                                    .message("email or password invalide")
                                    .status(HttpStatus.UNAUTHORIZED.value())
                                    .timestamp(LocalDateTime.now())
                                    .build()
                    );
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        String token = jwtService.generateToken(userDetails);

        String role = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(per -> per.startsWith("ROLE_"))
                .findFirst()
                .orElse("UNKNOWN");

        return ResponseEntity.ok(
                LoginResponse.builder()
                        .message("Authentication passed!")
                        .role(role)
                        .token(token)
                        .build()
        );
    }
}
