package com.clarxlabs.ellion.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record UserData(
        @NotEmpty
        @Length(min = 2, max = 160)
        String fullName,

        @NotEmpty
        @Length(min = 3, max = 160)
        @Email
        String email,

        @NotEmpty
        @Length(min = 6, max = 72)
        @Pattern(regexp = "^(?=.*[^a-zA-Z0-9])\\S+$", message = "must have special character(s). Ex: !?@#*$%&")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])\\S+$", message = "must have number(s), lower and upper case character(s)")
        String password
) {
}
