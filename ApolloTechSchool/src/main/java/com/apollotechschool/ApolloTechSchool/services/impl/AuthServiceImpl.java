package com.apollotechschool.ApolloTechSchool.services.impl;

import com.apollotechschool.ApolloTechSchool.dtos.LoginDto;
import com.apollotechschool.ApolloTechSchool.dtos.UserDto;
import com.apollotechschool.ApolloTechSchool.entities.BlacklistedToken;
import com.apollotechschool.ApolloTechSchool.entities.Role;
import com.apollotechschool.ApolloTechSchool.entities.User;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityAlreadyExistsException;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.UserPayload;
import com.apollotechschool.ApolloTechSchool.repositories.BlacklistedTokenRepository;
import com.apollotechschool.ApolloTechSchool.repositories.RoleRepository;
import com.apollotechschool.ApolloTechSchool.repositories.UserRepository;
import com.apollotechschool.ApolloTechSchool.security.JwtUtil;
import com.apollotechschool.ApolloTechSchool.services.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/* Auth ServiceImpl
 * Authentication Path Service Implementation
 * Establish Business Logic on DB interactions related to authenticating users
 * */

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BlacklistedTokenRepository blacklistedTokenRepository;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, BlacklistedTokenRepository blacklistedTokenRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.blacklistedTokenRepository = blacklistedTokenRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserPayload register(UserDto userDto) {
        // Check if email isn't already registered
        if (userRepository.existsByEmail(userDto.getEmail()))
        {
            throw new EntityAlreadyExistsException("User of email " + userDto.getEmail() + " already exists");
        }

        // Create new User
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // Set User Roles
        Set<Role> roles = new HashSet<Role>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        User newUser = userRepository.save(user);

        UserPayload userPayload = new UserPayload();

        userPayload.setId(newUser.getId());
        userPayload.setFirstName(newUser.getFirstName());
        userPayload.setLastName(newUser.getLastName());
        userPayload.setEmail(newUser.getEmail());
        userPayload.setPicUrl(newUser.getPicUrl());

        return userPayload;
    }

    @Override
    public UserPayload login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(
                () -> new EntityNotFoundException("The user of email " + loginDto.getEmail() + " could not be found")
        );

        String token = jwtUtil.generateToken(authentication);

        return new UserPayload(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPicUrl(),
                token
        );
    }

    // Log the user out of the system
    @Override
    public String logout(String token) {

        // If no token or blank token, throw error
        if (token == null || token.isBlank())
        {
            throw new EntityAlreadyExistsException("No JWT Authentication token could be found");
        }

        // Throw error if token has been already blacklisted
        if (blacklistedTokenRepository.existsByToken(token))
        {
            throw new IllegalStateException("Token is already blacklisted");
        }

        // Get token expiration date
        Instant expire = jwtUtil.extractExpiration(token);

        // Add a new blacklisted token
        BlacklistedToken blacklistedToken = new BlacklistedToken(
                token,
                Date.from(expire)
        );

        blacklistedTokenRepository.save(blacklistedToken);

        // Clear Authentication
        SecurityContextHolder.clearContext();

        return "You successfully logged out from the system";
    }
}
