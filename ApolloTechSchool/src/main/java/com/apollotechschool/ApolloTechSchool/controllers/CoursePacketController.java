package com.apollotechschool.ApolloTechSchool.controllers;

/* CoursePacketController
 * Handle HTTP Requests related to the Category Entity
 * */

import com.apollotechschool.ApolloTechSchool.payloads.CoursePacketPayload;
import com.apollotechschool.ApolloTechSchool.services.CoursePacketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course-packets")
public class CoursePacketController
{
    private CoursePacketService coursePacketService;

    public CoursePacketController(CoursePacketService coursePacketService) {
        this.coursePacketService = coursePacketService;
    }

    @GetMapping
    public ResponseEntity<List<CoursePacketPayload>> getAllCoursePackets()
    {
        List<CoursePacketPayload> coursePacketPayloads = coursePacketService.getAllCoursePackets();
        return ResponseEntity.ok(coursePacketPayloads);
    }

    @GetMapping("{id}")
    public ResponseEntity<CoursePacketPayload> getCoursePacketById(@PathVariable("id") Long id)
    {
        CoursePacketPayload coursePacketPayload = coursePacketService.getCoursePacketById(id);
        return ResponseEntity.ok(coursePacketPayload);
    }
}
