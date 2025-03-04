package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.payloads.CoursePayload;
import com.apollotechschool.ApolloTechSchool.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/* CourseController
 * Handle HTTP Requests related to the Course Entity
 * */

@RestController
@RequestMapping("/api/courses")
public class CourseController
{
    private CourseService courseService;

    public CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CoursePayload>> getAllCourses()
    {
        List<CoursePayload> coursePayloads = courseService.getAllCourses();
        return ResponseEntity.ok(coursePayloads);
    }

    @GetMapping("{id}")
    public ResponseEntity<CoursePayload> getCourseById(@PathVariable("id") Long id)
    {
        CoursePayload coursePayload = courseService.getCourseById(id);
        return ResponseEntity.ok(coursePayload);
    }
}
