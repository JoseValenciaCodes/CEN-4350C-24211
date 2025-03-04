package com.apollotechschool.ApolloTechSchool.repositories;

/* PaymentRepository
*
* Handle DB interactions on the Payment Entity
* */

import com.apollotechschool.ApolloTechSchool.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
}
