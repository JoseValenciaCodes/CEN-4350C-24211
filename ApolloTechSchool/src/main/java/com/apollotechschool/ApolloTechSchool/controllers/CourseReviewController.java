package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.payloads.CourseReviewPayload;
import com.apollotechschool.ApolloTechSchool.services.CourseReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* CourseReviewController
 * Handle HTTP Requests related to the CourseReview Entity
 * */
@RestController
@RequestMapping("/api/course-reviews")
public class CourseReviewController
{
    CourseReviewService courseReviewService;

    public CourseReviewController(CourseReviewService courseReviewService) {
        this.courseReviewService = courseReviewService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<CourseReviewPayload>> getCourseReviewsByCourseId(@PathVariable("id") Long courseId)
    {
        List<CourseReviewPayload> courseReviewPayloads = courseReviewService.getCourseReviewsByCourseId(courseId);
        return ResponseEntity.ok(courseReviewPayloads);
    }

    @GetMapping("/course-review/{id}")
    public ResponseEntity<CourseReviewPayload> getCourseReviewById(@PathVariable("id") Long id)
    {
        CourseReviewPayload courseReviewPayload = courseReviewService.getCourseReviewById(id);
        return ResponseEntity.ok(courseReviewPayload);
    }
}
