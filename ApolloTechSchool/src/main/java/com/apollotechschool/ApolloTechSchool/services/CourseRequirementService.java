package com.apollotechschool.ApolloTechSchool.services;

import com.apollotechschool.ApolloTechSchool.payloads.CourseRequirementPayload;

import java.util.List;

/* CourseRequirementService
 * Contract to establish the methods of the CourseRequirement Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */
public interface CourseRequirementService
{
    List<CourseRequirementPayload> getCourseRequirementsByCourseId(Long courseId);
    CourseRequirementPayload getCourseRequirementById(Long courseRequirementId);
}
