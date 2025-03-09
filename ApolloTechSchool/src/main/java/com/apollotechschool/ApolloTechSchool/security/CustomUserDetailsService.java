package com.apollotechschool.ApolloTechSchool.security;

import com.apollotechschool.ApolloTechSchool.entities.User;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

/* CustomerUserDetailsService Class
* Implementation of the UserDetailsService Interface
* Needed by Spring Security to authenticate users into JWT Tokens
* */
@Service
public class CustomUserDetailsService implements UserDetailsService
{
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Load user by email instead of by username
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Grab a user from the DB
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("User of email " + email + " could not be found")
        );

        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        // Return Spring User Details User
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
