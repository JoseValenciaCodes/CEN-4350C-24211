package com.apollotechschool.ApolloTechSchool.entities;

/* BlacklistedToken Entity
* JWT Tokens that are no longer accepted because the user chose to logout */

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "blacklisted_tokens")
public class BlacklistedToken
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Date expiryDate;

    public BlacklistedToken() {}

    public BlacklistedToken(String token, Date expiryDate) {
        this.token = token;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.before(new Date());
    }
}
