package com.nsmaniotto.bowt.ws.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "login")
public class SignUpDto {

    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @NotBlank
    @Size(min = 2, max = 10)
    private String login;

    @NotBlank
    @Size(min = 2, max = 20)
    private String password;
}
