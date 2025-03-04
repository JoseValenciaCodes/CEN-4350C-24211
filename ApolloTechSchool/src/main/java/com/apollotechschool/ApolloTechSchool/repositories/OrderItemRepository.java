package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/* OrderItemRepository
* Handle DB Transactions on the OrderItem Entity
* */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{
}
