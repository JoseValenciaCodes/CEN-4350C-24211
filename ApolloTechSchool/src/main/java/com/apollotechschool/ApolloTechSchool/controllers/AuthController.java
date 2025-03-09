package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.dtos.LoginDto;
import com.apollotechschool.ApolloTechSchool.dtos.UserDto;
import com.apollotechschool.ApolloTechSchool.payloads.MessagePayload;
import com.apollotechschool.ApolloTechSchool.payloads.UserPayload;
import com.apollotechschool.ApolloTechSchool.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController
{
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = {"/register", "/signup", "/sign-up"})
    public ResponseEntity<UserPayload> register(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(authService.register(userDto));
    }

    @PostMapping(value = {"/login", "/signin", "/sign-in"})
    public ResponseEntity<UserPayload> login(@RequestBody LoginDto loginDto)
    {
        return ResponseEntity.ok(authService.login(loginDto));
    }

    @PostMapping(value = {"/logout", "/signout", "/sign-out"})
    public ResponseEntity<MessagePayload> logout(@RequestHeader("Authorization") String authHeader)
    {
        String token = authHeader.substring(7);
        String logoutFeedback = authService.logout(token);
        return ResponseEntity.ok(new MessagePayload(logoutFeedback));
    }
}
