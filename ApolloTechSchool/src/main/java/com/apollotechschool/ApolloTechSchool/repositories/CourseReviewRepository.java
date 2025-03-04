package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.CourseReview;
import org.springframework.data.jpa.repository.JpaRepository;

/* CourseReviewRepository
 *  Handle DB Transactions on the CourseReview Entity
 * */
public interface CourseReviewRepository extends JpaRepository<CourseReview, Long>
{
}
