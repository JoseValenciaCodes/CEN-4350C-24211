package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

/* MembershipRepository
 *  Handle DB Transactions on the Membership Entity
 * */
public interface MembershipRepository extends JpaRepository<Membership, Long>
{
}
