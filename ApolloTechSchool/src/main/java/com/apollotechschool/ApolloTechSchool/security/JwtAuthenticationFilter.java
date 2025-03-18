package com.apollotechschool.ApolloTechSchool.security;

import com.apollotechschool.ApolloTechSchool.exceptions.EcommerceApiException;
import com.apollotechschool.ApolloTechSchool.repositories.BlacklistedTokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/* JwtAuthenticationFilter intercepts HTTP requests, extract JWT Tokens, and authenticates the user
*
* */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    private final BlacklistedTokenRepository blacklistedTokenRepository;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService, BlacklistedTokenRepository blacklistedTokenRepository) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.blacklistedTokenRepository = blacklistedTokenRepository;
    }

    // Intercept HTTP Requests
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        try
        {
            String token = getTokenFromRequest(request);

            // Check token is valid
            if (StringUtils.hasText(token) && jwtUtil.validateToken(token))
            {
                if (blacklistedTokenRepository.existsByToken(token))
                {
                    throw new EcommerceApiException(HttpStatus.UNAUTHORIZED, "Token is already blacklisted");
                }


                String email = jwtUtil.getEmail(token);

                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("Could not set user authentication is security context", e);
        }

        filterChain.doFilter(request, response);
    }

    // Get JWT Token in HTTP Request
    private String getTokenFromRequest(HttpServletRequest httpServletRequest)
    {
        String bearerToken = httpServletRequest.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
        {
            return bearerToken.substring(7);
        }

        return null;
    }
}
