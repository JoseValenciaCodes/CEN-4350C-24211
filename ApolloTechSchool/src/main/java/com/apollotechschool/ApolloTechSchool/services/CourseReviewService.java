package com.apollotechschool.ApolloTechSchool.services;

import com.apollotechschool.ApolloTechSchool.payloads.CourseReviewPayload;

import java.util.List;

/* CourseReviewService
 * Contract to establish the methods of the CourseReview Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */
public interface CourseReviewService
{
    List<CourseReviewPayload> getCourseReviewsByCourseId(Long courseId);
    CourseReviewPayload getCourseReviewById(Long courseReviewId);
}
