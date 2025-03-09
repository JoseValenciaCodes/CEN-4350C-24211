package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/* RoleRepository
* Handle DB Transactions related to the Role Entity
* */
public interface RoleRepository extends JpaRepository<Role, Long>
{
    Optional<Role> findByName(String name);
}
