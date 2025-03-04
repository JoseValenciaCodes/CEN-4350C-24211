package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.LearningPath;
import org.springframework.data.jpa.repository.JpaRepository;

/* LearningPathRepository
 *  Handle DB Transactions on the LearningPath Entity
 * */
public interface LearningPathRepository extends JpaRepository<LearningPath, Long>
{
}
