package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.CourseRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

/* CourseRequirementRepository
 *  Handle DB Transactions on the CourseRequirement Entity
 * */
public interface CourseRequirementRepository extends JpaRepository<CourseRequirement, Long>
{
}
