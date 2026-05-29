package com.coinflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegisterRequest {

    @NotNull
    @Email
    private String email;
    private String password, firstName, lastName;
}
