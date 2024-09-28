package com.nsmaniotto.bowt.ws.dto.auth;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "login")
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String login;
    private char[] password;
}
