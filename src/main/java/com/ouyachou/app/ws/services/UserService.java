package com.ouyachou.app.ws.services;


import com.ouyachou.app.ws.shared.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
}