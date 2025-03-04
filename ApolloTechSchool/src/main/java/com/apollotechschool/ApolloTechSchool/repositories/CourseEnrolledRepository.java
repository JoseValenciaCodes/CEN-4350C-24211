package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.CourseEnrolled;
import org.springframework.data.jpa.repository.JpaRepository;

/* CourseEnrolledRepository
 *  Handle DB Transactions on the Course Entity
 * */
public interface CourseEnrolledRepository extends JpaRepository<CourseEnrolled, Long>
{
}
