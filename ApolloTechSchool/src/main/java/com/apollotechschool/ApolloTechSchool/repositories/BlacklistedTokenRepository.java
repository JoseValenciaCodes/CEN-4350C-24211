package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.BlacklistedToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/* BlacklistedTokenRepository
* Handle DB Transactions related to the BlacklistedToken Entity*/

public interface BlacklistedTokenRepository extends JpaRepository<BlacklistedToken, Long> {
    Optional<BlacklistedToken> findByToken(String token); // Find token to blacklist
    boolean existsByToken(String token); // Get if a JWT token exists or not
}
