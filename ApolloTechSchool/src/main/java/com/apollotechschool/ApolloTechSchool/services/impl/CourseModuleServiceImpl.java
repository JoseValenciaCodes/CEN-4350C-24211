package com.apollotechschool.ApolloTechSchool.services.impl;

import com.apollotechschool.ApolloTechSchool.entities.Course;
import com.apollotechschool.ApolloTechSchool.entities.CourseModule;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.CourseModulePayload;
import com.apollotechschool.ApolloTechSchool.repositories.CourseModuleRepository;
import com.apollotechschool.ApolloTechSchool.repositories.CourseRepository;
import com.apollotechschool.ApolloTechSchool.services.CourseModuleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* CourseModuleServiceImpl
 * CourseModule Service Implementation
 * Establish Business Logic on DB interactions related to the CourseModule Entity
 * */
@Service
@Transactional
public class CourseModuleServiceImpl implements CourseModuleService
{
    public CourseRepository courseRepository;
    public CourseModuleRepository courseModuleRepository;

    public CourseModuleServiceImpl(CourseRepository courseRepository, CourseModuleRepository courseModuleRepository) {
        this.courseRepository = courseRepository;
        this.courseModuleRepository = courseModuleRepository;
    }

    @Override
    public List<CourseModulePayload> getCourseModulesByCourseId(Long courseId) {

        // Try to find the course first
        courseRepository.findById(courseId).orElseThrow(
                () -> new EntityNotFoundException("Course of id " + courseId + " could not be found")
        );

        // Find the modules of this course
        List<CourseModule> courseModules = courseModuleRepository.findAll().stream().filter(courseModule -> Objects.equals(courseModule.getCourse().getId(), courseId)).toList();
        List<CourseModulePayload> courseModulePayloads = new ArrayList<CourseModulePayload>();

        for (CourseModule courseModule : courseModules)
        {
            courseModulePayloads.add(new CourseModulePayload(
                    courseModule.getId(),
                    courseModule.getTitle(),
                    courseModule.getDescription(),
                    courseModule.getCourse().getId()
            ));
        }

        return courseModulePayloads;
    }

    @Override
    public CourseModulePayload getCourseModuleById(Long courseModuleId) {

        CourseModule courseModule = courseModuleRepository.findById(courseModuleId).orElseThrow(
                () -> new EntityNotFoundException("Course Module of id " + courseModuleId + " could not be found")
        );

        return new CourseModulePayload(
                courseModule.getId(),
                courseModule.getTitle(),
                courseModule.getDescription(),
                courseModule.getCourse().getId()
        );
    }
}
