package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/* CategoryRepository
 *  Handle DB Transactions on the Category Entity
 * */
public interface CategoryRepository extends JpaRepository<Category, Long>
{
}
