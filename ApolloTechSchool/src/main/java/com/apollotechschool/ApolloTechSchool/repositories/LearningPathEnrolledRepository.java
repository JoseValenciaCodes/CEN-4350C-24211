package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.LearningPathEnrolled;
import org.springframework.data.jpa.repository.JpaRepository;

/* LearningPathEnrolledRepository
 *  Handle DB Transactions on the LearningPathEnrolled Entity
 * */
public interface LearningPathEnrolledRepository extends JpaRepository<LearningPathEnrolled, Long>
{
}
