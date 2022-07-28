package com.io.nest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.io.nest.dto.UserDto;
import com.io.nest.model.User;


@Mapper
public interface UserMapper {
	UserDto convertToMobilePhoneDto(User user);
	
	User updateMobilePhoneEntity(UserDto userDto, @MappingTarget User user);

}
