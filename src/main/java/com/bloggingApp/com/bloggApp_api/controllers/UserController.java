package com.bloggingApp.com.bloggApp_api.controllers;


import com.bloggingApp.com.bloggApp_api.payloads.ApiResponse;
import com.bloggingApp.com.bloggApp_api.payloads.UserDto;
import com.bloggingApp.com.bloggApp_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

//    POST -CREATE USER
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto , HttpStatus.CREATED);

    }

//    PUT -UPDATE USDER
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto , @PathVariable("userId") Integer uid){

        UserDto updatedUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);


    }

//    Delete - USER
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new  ResponseEntity<ApiResponse> (new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

//    Get - user get   endpoint
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());

    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));

    }


}
