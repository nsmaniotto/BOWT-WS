package com.nsmaniotto.bowt.ws.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredentialsDto {

    @NotBlank
    @Size(min = 2, max = 10)
    private String login;

    @NotBlank
    @Size(min = 5, max = 20)
    private String password;
}