package com.nsmaniotto.bowt.ws.controller.auth;

import com.nsmaniotto.bowt.ws.config.UserAuthenticationProvider;
import com.nsmaniotto.bowt.ws.dto.auth.CredentialsDto;
import com.nsmaniotto.bowt.ws.dto.auth.SignUpDto;
import com.nsmaniotto.bowt.ws.dto.user.UserDto;
import com.nsmaniotto.bowt.ws.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @GetMapping(value = "user/{token}")
    public ResponseEntity<UserDto> getConnectedUser(@PathVariable String token) {
        Object principal = userAuthenticationProvider.validateToken(token).getPrincipal();

        if (principal instanceof UserDto) {
            UserDto userDto = (UserDto) principal;
            // Proceed with using userDto
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

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
