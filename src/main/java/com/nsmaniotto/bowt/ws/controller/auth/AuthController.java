package com.nsmaniotto.bowt.ws.controller.auth;

import com.nsmaniotto.bowt.ws.config.UserAuthenticationProvider;
import com.nsmaniotto.bowt.ws.dto.auth.CredentialsDto;
import com.nsmaniotto.bowt.ws.dto.auth.SignUpDto;
import com.nsmaniotto.bowt.ws.dto.user.UserDto;
import com.nsmaniotto.bowt.ws.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}
