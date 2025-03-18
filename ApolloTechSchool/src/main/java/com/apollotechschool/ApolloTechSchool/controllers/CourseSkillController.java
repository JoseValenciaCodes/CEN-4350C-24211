package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.payloads.CourseSkillPayload;
import com.apollotechschool.ApolloTechSchool.services.CourseSkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* CourseSkillController
* Handle HTTP Requests related to the CourseSkill Entity
* */
@RestController
@RequestMapping("/api/course-skills")
public class CourseSkillController
{
    CourseSkillService courseSkillService;

    public CourseSkillController(CourseSkillService courseSkillService) {
        this.courseSkillService = courseSkillService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<CourseSkillPayload>> getCourseSkillsByCourseId(@PathVariable("id") Long courseId)
    {
        List<CourseSkillPayload> courseSkillPayloads = courseSkillService.getCourseSkillsByCourseId(courseId);
        return ResponseEntity.ok(courseSkillPayloads);
    }

    @GetMapping("/course-skill/{id}")
    public ResponseEntity<CourseSkillPayload> getCourseSkillById(@PathVariable("id") Long id)
    {
        CourseSkillPayload courseSkillPayload = courseSkillService.getCourseSkillById(id);
        return ResponseEntity.ok(courseSkillPayload);
    }
}
