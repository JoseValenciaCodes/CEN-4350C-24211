package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.dtos.UpdateUserDto;
import com.apollotechschool.ApolloTechSchool.dtos.UserDto;
import com.apollotechschool.ApolloTechSchool.payloads.UserPayload;
import com.apollotechschool.ApolloTechSchool.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Controller to modify User Data */
@RestController
@RequestMapping("/api/user")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PutMapping
    public ResponseEntity<UserPayload> updateUser(@RequestBody UpdateUserDto updateUserDto)
    {
        UserPayload userPayload = userService.updateUser(updateUserDto);
        return ResponseEntity.ok(userPayload);
    }
}
