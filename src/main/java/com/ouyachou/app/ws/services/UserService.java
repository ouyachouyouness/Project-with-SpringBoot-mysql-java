package com.ouyachou.app.ws.services;


import com.ouyachou.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);

    UserDto getUser(String email);

    UserDto getUserByUserId (String userId);

    UserDto updateUser(String id, UserDto userDto);
}