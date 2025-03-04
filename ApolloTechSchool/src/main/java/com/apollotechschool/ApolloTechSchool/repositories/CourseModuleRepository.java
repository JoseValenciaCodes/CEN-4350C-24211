package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;

/* CourseModuleRepository
 *  Handle DB Transactions on the CourseModule Entity
 * */
public interface CourseModuleRepository extends JpaRepository<CourseModule, Long>
{
}
