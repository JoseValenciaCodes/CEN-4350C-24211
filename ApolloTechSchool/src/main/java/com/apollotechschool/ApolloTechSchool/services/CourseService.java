package com.apollotechschool.ApolloTechSchool.services;

import com.apollotechschool.ApolloTechSchool.payloads.CoursePayload;

import java.util.List;

/* CourseService
 * Contract to establish the methods of the Course Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */
public interface CourseService
{
    List<CoursePayload> getAllCourses();
    CoursePayload getCourseById(Long id);
}
