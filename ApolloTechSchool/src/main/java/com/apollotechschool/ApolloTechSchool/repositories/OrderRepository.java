package com.apollotechschool.ApolloTechSchool.repositories;

/* OrderRepository
* Handle DB Transactions on the Order Entity
* */

import com.apollotechschool.ApolloTechSchool.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/* OrderRepository
*  Handle DB Transactions on the Order Entity
* */
public interface OrderRepository extends JpaRepository<Order, Long>
{
}
