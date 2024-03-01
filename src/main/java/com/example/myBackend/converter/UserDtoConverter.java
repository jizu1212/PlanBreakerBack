package com.example.myBackend.converter;

import com.example.myBackend.dto.UserAuthDto;
import com.example.myBackend.dto.UserBusinessDto;
import com.example.myBackend.model.User;

public class UserDtoConverter {
    public UserAuthDto convertToAuthDto(User user) {
        UserAuthDto userDto = new UserAuthDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public UserBusinessDto convertToBusinessDto(User user) {
        UserBusinessDto userDto = new UserBusinessDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRewards(user.getRewards());
        return userDto;
    }

    public User convertToEntity(UserAuthDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return user;
    }
    public User convertToEntity(UserBusinessDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return user;
    }
}