package com.apollotechschool.ApolloTechSchool.services.impl;

/* Implementation of Service to deal with the User Entity */

import com.apollotechschool.ApolloTechSchool.dtos.UpdateUserDto;
import com.apollotechschool.ApolloTechSchool.dtos.UserDto;
import com.apollotechschool.ApolloTechSchool.entities.User;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.UserPayload;
import com.apollotechschool.ApolloTechSchool.repositories.UserRepository;
import com.apollotechschool.ApolloTechSchool.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserPayload updateUser(UpdateUserDto updateUserDto) {

        // First find the user
        User user = userRepository.findById(updateUserDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("User could not be found")
        );

        // Change all details
        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setEmail(updateUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(updateUserDto.getPassword()));

        // Save changes
        user = userRepository.save(user);

        // Return UserPayload
        UserPayload userPayload = new UserPayload();

        userPayload.setId(user.getId());
        userPayload.setFirstName(user.getFirstName());
        userPayload.setLastName(user.getLastName());
        userPayload.setEmail(user.getEmail());
        userPayload.setJwtToken(updateUserDto.getJwtToken());

        return userPayload;
    }
}
