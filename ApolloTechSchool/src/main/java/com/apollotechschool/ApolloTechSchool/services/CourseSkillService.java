package com.apollotechschool.ApolloTechSchool.services;

import com.apollotechschool.ApolloTechSchool.payloads.CourseSkillPayload;

import java.util.List;

/* CourseSkillService
 * Contract to establish the methods of the CourseSkill Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */
public interface CourseSkillService
{
    List<CourseSkillPayload> getCourseSkillsByCourseId(Long courseId);
    CourseSkillPayload getCourseSkillById(Long courseSkillId);
}
