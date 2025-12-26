package com.brickbase.platform.dto.requestDTO;

import com.brickbase.platform.enums.JobTypes;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "first name is required!")
    private String firstName;

    @NotBlank(message = "last name is required!")
    private String lastName;

    @Email
    @NotBlank(message = "mail is required!")
    private String email;

    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    private String phone;
    private String location;

    @NotBlank(message = "role is required!")
    private String role;

    // worker
    private String bio;
    private JobTypes jobTitle;
    private String category;

    @PositiveOrZero
    private float price;
}

