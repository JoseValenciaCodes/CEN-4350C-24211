package com.apollotechschool.ApolloTechSchool.services;

import com.apollotechschool.ApolloTechSchool.payloads.CoursePayload;
import com.apollotechschool.ApolloTechSchool.payloads.MessagePayload;
import org.aspectj.bridge.Message;

import java.util.List;

/* CourseService
 * Contract to establish the methods of the Course Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */
public interface CourseService
{
    List<CoursePayload> getAllCourses();
    CoursePayload getCourseById(Long id);
    MessagePayload enrollUserInCourse(Long courseId, Long userId);
    CoursePayload getCourseOfUser(Long courseId, Long userId);
    List<CoursePayload> getAllCourseOfUser(Long userId);
    MessagePayload unEnrollUserFromCourse(Long courseId, Long userId);
}
