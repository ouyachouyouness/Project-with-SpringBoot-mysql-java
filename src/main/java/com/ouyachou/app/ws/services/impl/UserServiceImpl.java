package com.ouyachou.app.ws.services.impl;


import com.ouyachou.app.ws.Entites.UserEntity;
import com.ouyachou.app.ws.repositories.UserRepository;
import com.ouyachou.app.ws.services.UserService;
import com.ouyachou.app.ws.shared.dto.UserDto;
import com.ouyachou.app.ws.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    //BCrycpPasswordEncoder bCrycpPasswordEncoder;


    @Autowired
    Utils utils;

    public UserDto createUser(UserDto user){

        UserEntity checkUser = userRepository.findByEmail(user.getEmail());

        if(checkUser != null) throw new RuntimeException("User already exist");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test paswword");
        userEntity.setUserId(utils.generateStringId(32));

        UserEntity newUser = userRepository.save(userEntity);

        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(newUser,userDto);

        return userDto;
    }
}