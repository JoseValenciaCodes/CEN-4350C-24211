package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.payloads.CoursePayload;
import com.apollotechschool.ApolloTechSchool.payloads.MessagePayload;
import com.apollotechschool.ApolloTechSchool.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/* CourseController
 * Handle HTTP Requests related to the Course Entity
 * */

@RestController
@RequestMapping("/api/courses")
public class CourseController
{
    private final CourseService courseService;

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

    @GetMapping("/getEnrolledCourse")
    public ResponseEntity<CoursePayload> getEnrolledCourse(@RequestParam Long userId, @RequestParam Long courseId)
    {
        CoursePayload coursePayload = courseService.getCourseOfUser(courseId, userId);
        return ResponseEntity.ok(coursePayload);
    }

    @PostMapping("/enroll")
    public ResponseEntity<MessagePayload> enroll(@RequestParam Long userId, @RequestParam Long courseId)
    {
        MessagePayload messagePayload = courseService.enrollUserInCourse(courseId, userId);
        return ResponseEntity.ok(messagePayload);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CoursePayload>> getCoursesOfUser(@PathVariable("userId") Long userId)
    {
        List<CoursePayload> coursePayloads = courseService.getAllCourseOfUser(userId);
        return ResponseEntity.ok(coursePayloads);
    }

    @DeleteMapping("/un-enroll")
    public ResponseEntity<MessagePayload> unEnroll(@RequestParam Long userId, @RequestParam Long courseId)
    {
        MessagePayload messagePayload = courseService.unEnrollUserFromCourse(courseId, userId);
        return ResponseEntity.ok(messagePayload);
    }
}
