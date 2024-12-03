package com.bloggingApp.com.bloggApp_api.services;

import com.bloggingApp.com.bloggApp_api.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto  user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);

}
