package com.apollotechschool.ApolloTechSchool.services;

/* CourseModuleService
 * Contract to establish the methods of the CourseModule Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */

import com.apollotechschool.ApolloTechSchool.payloads.CourseModulePayload;

import java.util.List;

public interface CourseModuleService
{
    List<CourseModulePayload> getCourseModulesByCourseId(Long courseId);
    CourseModulePayload getCourseModuleById(Long courseModuleId);
}
