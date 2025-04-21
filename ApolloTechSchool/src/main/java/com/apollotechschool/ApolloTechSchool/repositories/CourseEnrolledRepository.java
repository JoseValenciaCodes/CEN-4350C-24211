package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.CourseEnrolled;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/* CourseEnrolledRepository
 *  Handle DB Transactions on the Course Entity
 * */
public interface CourseEnrolledRepository extends JpaRepository<CourseEnrolled, Long>
{
    List<CourseEnrolled> findByUserId(Long userId);
    Optional<CourseEnrolled> findByUserIdAndCourseId(Long userId, Long courseId);
    void deleteByUserIdAndCourseId(Long userId, Long courseId);
}
