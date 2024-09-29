package com.nsmaniotto.bowt.ws.service.user;

import com.nsmaniotto.bowt.persistence.entity.user.User;
import com.nsmaniotto.bowt.persistence.repository.user.UserRepository;
import com.nsmaniotto.bowt.ws.dto.auth.CredentialsDto;
import com.nsmaniotto.bowt.ws.dto.auth.SignUpDto;
import com.nsmaniotto.bowt.ws.dto.user.UserDto;
import com.nsmaniotto.bowt.ws.exceptions.BowtException;
import com.nsmaniotto.bowt.ws.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new BowtException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new BowtException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.getLogin());

        if (optionalUser.isPresent()) {
            throw new BowtException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new BowtException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

}
