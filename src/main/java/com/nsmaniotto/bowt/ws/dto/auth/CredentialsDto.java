package com.nsmaniotto.bowt.ws.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredentialsDto {
    private String login;
    private char[] password;
}