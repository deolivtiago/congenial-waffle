package com.clarxlabs.ellion.controllers.requests;

import jakarta.validation.constraints.NotEmpty;

public record UserData(
        @NotEmpty
        String fullName,

        @NotEmpty
        String email,

        @NotEmpty
        String password

) {
}
