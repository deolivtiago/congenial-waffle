package com.clarxlabs.ellion.controllers.dtos;

import jakarta.validation.constraints.*;

public record UserData(
        @Min(value = 2)
        @Max(value = 255)
        @NotEmpty
        String fullName,

        @Email
        @Min(value = 3)
        @Max(value = 160)
        @NotEmpty
        String email,

        @Pattern(regexp = "[A-Za-z0-9]", message = "must have numbers, lower and upper case character(s)")
        @Pattern(regexp = "[!?@#$%^&*+._\\-]", message = "must have special character(s). Ex: !?@#$%^&*+._-")
        @Min(value = 6)
        @Max(value = 72)
        @NotEmpty
        String password
) {
}
