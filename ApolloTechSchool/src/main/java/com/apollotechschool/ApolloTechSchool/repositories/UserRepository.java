package com.apollotechschool.ApolloTechSchool.repositories;

/* UserRepository
* Handle DB Transactions on the User Entity
* */

import com.apollotechschool.ApolloTechSchool.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> existsByEmail(String email); // Check a user exists by email
}
