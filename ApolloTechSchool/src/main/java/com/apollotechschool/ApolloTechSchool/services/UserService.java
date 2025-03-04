package com.apollotechschool.ApolloTechSchool.services;

/* UserService
 * Contract to establish the methods of the User Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */

import com.apollotechschool.ApolloTechSchool.dtos.LoginDto;
import com.apollotechschool.ApolloTechSchool.dtos.UserDto;

public interface UserService
{
    String registerUser(UserDto userDto);
    String loginUser(LoginDto loginDto);
    void logoutUser(String token);
}
