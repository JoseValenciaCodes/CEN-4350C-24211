package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.CourseSkill;
import org.springframework.data.jpa.repository.JpaRepository;

/* CourseSkillRepository
 *  Handle DB Transactions on the CourseSkill Entity
 * */
public interface CourseSkillRepository extends JpaRepository<CourseSkill, Long>
{
}
