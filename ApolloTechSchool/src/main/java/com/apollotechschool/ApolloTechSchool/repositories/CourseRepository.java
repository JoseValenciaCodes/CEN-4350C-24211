package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/* Course
 *  Handle DB Transactions on the Course Entity
 * */
public interface CourseRepository extends JpaRepository<Course,Long>
{
}
