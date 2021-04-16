package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;

public interface UserService {

    public void signup(UserDTO dto);

    default UserEntity dtoToEntity(UserDTO userDTO){
        UserEntity userEntity = UserEntity.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .build();

        return userEntity;
    }
/*
    default UserDTO entityToDto(UserEntity userEntity){
        UserDTO userDTO = UserDTO.builder()
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .name(userEntity.getName())
                .build();

        return userDTO;
    }
*/
}
