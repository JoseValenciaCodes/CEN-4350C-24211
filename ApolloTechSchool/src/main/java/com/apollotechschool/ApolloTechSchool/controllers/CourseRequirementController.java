package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.payloads.CourseRequirementPayload;
import com.apollotechschool.ApolloTechSchool.services.CourseRequirementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* CourseRequirementController
* Handle HTTP Requests related to the CourseRequirement Entity
* */
@RestController
@RequestMapping("/api/course-requirements")
public class CourseRequirementController
{
    CourseRequirementService courseRequirementService;

    public CourseRequirementController(CourseRequirementService courseRequirementService) {
        this.courseRequirementService = courseRequirementService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<CourseRequirementPayload>> getCourseRequirementsByCourseId(@PathVariable("id") Long courseId)
    {
        List<CourseRequirementPayload> courseRequirementPayloads = courseRequirementService.getCourseRequirementsByCourseId(courseId);
        return ResponseEntity.ok(courseRequirementPayloads);
    }

    @GetMapping("/course-requirement/{id}")
    public ResponseEntity<CourseRequirementPayload> getCourseRequirementById(@PathVariable("id") Long id)
    {
        CourseRequirementPayload courseRequirementPayload = courseRequirementService.getCourseRequirementById(id);
        return ResponseEntity.ok(courseRequirementPayload);
    }
}
