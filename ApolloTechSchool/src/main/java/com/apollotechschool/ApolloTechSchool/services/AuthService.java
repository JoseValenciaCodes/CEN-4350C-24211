package com.apollotechschool.ApolloTechSchool.services;

/* AuthService
 * Contract to establish the methods of the Authentication Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */

import com.apollotechschool.ApolloTechSchool.dtos.LoginDto;
import com.apollotechschool.ApolloTechSchool.dtos.UserDto;
import com.apollotechschool.ApolloTechSchool.payloads.UserPayload;

public interface AuthService
{
    UserPayload register(UserDto userDto);
    UserPayload login(LoginDto loginDto);
    String logout(String token);
}
