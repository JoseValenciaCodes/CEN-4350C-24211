package com.apollotechschool.ApolloTechSchool.services.impl;

/* CourseServiceImpl
 * Course Service Implementation
 * Establish Business Logic on DB interactions related to the Course Entity
 * */

import com.apollotechschool.ApolloTechSchool.entities.Course;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.CategoryPayload;
import com.apollotechschool.ApolloTechSchool.payloads.CoursePayload;
import com.apollotechschool.ApolloTechSchool.repositories.CourseRepository;
import com.apollotechschool.ApolloTechSchool.services.CategoryService;
import com.apollotechschool.ApolloTechSchool.services.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CoursePayload> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CoursePayload> coursePayloads = new ArrayList<CoursePayload>();

        for (Course course : courses)
        {
            coursePayloads.add(new CoursePayload(
                    course.getId(),
                    course.getTitle(),
                    course.getDescription(),
                    course.getPicUrl(),
                    course.getLevel(),
                    course.getCategory().getId(),
                    course.getCoursePacket() == null ? null : course.getCoursePacket().getId(),
                    course.getLearningPath() == null ? null : course.getLearningPath().getId()
            ));
        }

        return coursePayloads;
    }

    @Override
    public CoursePayload getCourseById(Long id)
    {

        Course course = courseRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("The course of id " + id + " could not be found")
        );

        return new CoursePayload(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getPicUrl(),
                course.getLevel(),
                course.getCategory().getId(),
                course.getCoursePacket() == null ? null : course.getCoursePacket().getId(),
                course.getLearningPath() == null ? null : course.getLearningPath().getId()
        );
    }
}
