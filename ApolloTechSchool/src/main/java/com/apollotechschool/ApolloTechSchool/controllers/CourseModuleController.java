package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.payloads.CourseModulePayload;
import com.apollotechschool.ApolloTechSchool.services.CourseModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* CourseModuleController
 * Handle HTTP Requests related to the CourseModule Entity
 * */
@RestController
@RequestMapping("/api/course-modules")
public class CourseModuleController
{
    CourseModuleService courseModuleService;

    public CourseModuleController(CourseModuleService courseModuleService) {
        this.courseModuleService = courseModuleService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<CourseModulePayload>> getCourseModulesByCourseId(@PathVariable("id") Long courseId)
    {
        List<CourseModulePayload> courseModulePayloads = courseModuleService.getCourseModulesByCourseId(courseId);
        return ResponseEntity.ok(courseModulePayloads);
    }

    @GetMapping("/course-module/{id}")
    public ResponseEntity<CourseModulePayload> getCourseModuleById(@PathVariable("id") Long id)
    {
        CourseModulePayload courseModulePayload = courseModuleService.getCourseModuleById(id);
        return ResponseEntity.ok(courseModulePayload);
    }
}
