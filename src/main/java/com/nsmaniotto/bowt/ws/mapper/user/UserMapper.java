package com.nsmaniotto.bowt.ws.mapper.user;

import com.nsmaniotto.bowt.persistence.entity.user.User;
import com.nsmaniotto.bowt.ws.dto.auth.SignUpDto;
import com.nsmaniotto.bowt.ws.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
