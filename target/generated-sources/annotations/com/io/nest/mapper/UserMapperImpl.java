package com.io.nest.mapper;

import com.io.nest.dto.UserDto;
import com.io.nest.model.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-28T09:28:50+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto convertToMobilePhoneDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setUserId( user.getUserId() );

        return userDto;
    }

    @Override
    public User updateMobilePhoneEntity(UserDto userDto, User user) {
        if ( userDto == null ) {
            return null;
        }

        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );
        user.setUserId( userDto.getUserId() );

        return user;
    }
}
