package com.apollotechschool.ApolloTechSchool.security;

import com.apollotechschool.ApolloTechSchool.exceptions.EcommerceApiException;
import com.apollotechschool.ApolloTechSchool.repositories.BlacklistedTokenRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

/* JwtUtil Class
* Generate and Validate JWT Tokens
* */
@Component
public class JwtUtil
{
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private String jwtExpiration;

    private BlacklistedTokenRepository blacklistedTokenRepository;

    public JwtUtil(BlacklistedTokenRepository blacklistedTokenRepository) {
        this.blacklistedTokenRepository = blacklistedTokenRepository;
    }

    // Generate a new JWT Token
    public String generateToken(Authentication authentication)
    {
        String email = authentication.getName();

        Date currentDate = new Date();

        Date expiryDate = new Date(currentDate.getTime() + Long.parseLong(jwtExpiration));

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(key())
                .compact();
    }

    // Get user email from token
    public String getEmail(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validate Token
    public boolean validateToken(String token)
    {
        try
        {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);

            // If token is blacklisted, return error
            if (blacklistedTokenRepository.existsByToken(token))
            {
                throw new EcommerceApiException(HttpStatus.UNAUTHORIZED, "Invalid JWT Token");
            }

            return true;
        }

        catch (MalformedJwtException malformedJwtException)
        {
            throw new EcommerceApiException(HttpStatus.BAD_REQUEST, "Invalid JWT Token");
        }

        catch (ExpiredJwtException expiredJwtException)
        {
            throw new EcommerceApiException(HttpStatus.BAD_REQUEST, "Expired JWT Token");
        }

        catch (UnsupportedJwtException unsupportedJwtException)
        {
            throw new EcommerceApiException(HttpStatus.BAD_REQUEST, "Unsupported JWT Token");
        }

        catch (IllegalArgumentException illegalArgumentException)
        {
            throw new EcommerceApiException(HttpStatus.BAD_REQUEST, "Jwt claims string is null or empty");
        }
    }

    // Extract expiration time
    public Instant extractExpiration(String token)
    {
        Claims claims =Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration().toInstant();
    }

    private Key key()
    {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
}
