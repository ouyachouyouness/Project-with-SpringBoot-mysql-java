package com.ouyachou.app.ws.services.impl;


import com.ouyachou.app.ws.Entites.UserEntity;
import com.ouyachou.app.ws.repositories.UserRepository;
import com.ouyachou.app.ws.services.UserService;
import com.ouyachou.app.ws.shared.dto.UserDto;
import com.ouyachou.app.ws.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    //BCrycpPasswordEncoder bCrycpPasswordEncoder;


    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserDto createUser(UserDto user){

        UserEntity checkUser = userRepository.findByEmail(user.getEmail());

        if(checkUser != null) throw new RuntimeException("User already exist");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserId(utils.generateStringId(32));

        UserEntity newUser = userRepository.save(userEntity);

        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(newUser,userDto);

        return userDto;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity =  userRepository.findByEmail(email);
        if(userEntity == null) throw new UsernameNotFoundException(email);
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userEntity,userDto);

        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {

        UserEntity userEntity =  userRepository.findByUserId(userId);

        if(userEntity == null) throw new UsernameNotFoundException(userId);

        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userEntity,userDto);


        return userDto;
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {

        UserEntity userEntity =  userRepository.findByUserId(userId);

        if(userEntity == null) throw new UsernameNotFoundException(userId);

        userEntity.setFirstName(userDto.getFirstName());

        userEntity.setLastName(userDto.getLastName());

        UserEntity userUpdated = userRepository.save(userEntity);

        UserDto user = new UserDto();

        BeanUtils.copyProperties(userUpdated, user);


        return user;
    }

    @Override
    public void deleteUser(String userId) {

        UserEntity userEntity =  userRepository.findByUserId(userId);

        if(userEntity == null) throw new UsernameNotFoundException(userId);

        userRepository.delete(userEntity);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity =  userRepository.findByEmail(email);

        if(userEntity == null) throw new UsernameNotFoundException(email);


        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}