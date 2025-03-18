package com.apollotechschool.ApolloTechSchool.services.impl;

import com.apollotechschool.ApolloTechSchool.entities.CourseRequirement;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.CourseRequirementPayload;
import com.apollotechschool.ApolloTechSchool.repositories.CourseRepository;
import com.apollotechschool.ApolloTechSchool.repositories.CourseRequirementRepository;
import com.apollotechschool.ApolloTechSchool.services.CourseRequirementService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* CourseRequirementServiceImpl
 * CourseRequirement Service Implementation
 * Establish Business Logic on DB interactions related to the CourseRequirement Entity
 * */
@Service
@Transactional
public class CourseRequirementServiceImpl implements CourseRequirementService
{
    public CourseRepository courseRepository;
    public CourseRequirementRepository courseRequirementRepository;

    public CourseRequirementServiceImpl(CourseRepository courseRepository, CourseRequirementRepository courseRequirementRepository) {
        this.courseRepository = courseRepository;
        this.courseRequirementRepository = courseRequirementRepository;
    }

    @Override
    public List<CourseRequirementPayload> getCourseRequirementsByCourseId(Long courseId) {

        // Try to find the course first
        courseRepository.findById(courseId).orElseThrow(
                () -> new EntityNotFoundException("Course Requirement of id " + courseId + " could not be found")
        );

        // Find the requirement of this course
        List<CourseRequirement> courseRequirements = courseRequirementRepository.findAll().stream().filter(courseRequirement -> Objects.equals(courseRequirement.getCourse().getId(), courseId)).toList();
        List<CourseRequirementPayload> courseRequirementPayloads = new ArrayList<CourseRequirementPayload>();

        for (CourseRequirement courseRequirement : courseRequirements)
        {
            courseRequirementPayloads.add(new CourseRequirementPayload(
                    courseRequirement.getId(),
                    courseRequirement.getRequirement(),
                    courseRequirement.getCourse().getId()
            ));
        }

        return courseRequirementPayloads;
    }

    @Override
    public CourseRequirementPayload getCourseRequirementById(Long courseRequirementId) {

        CourseRequirement courseRequirement = courseRequirementRepository.findById(courseRequirementId).orElseThrow(
                () -> new EntityNotFoundException("Course Requirement of id " + courseRequirementId + " could not be found")
        );

        return new CourseRequirementPayload(
                courseRequirement.getId(),
                courseRequirement.getRequirement(),
                courseRequirement.getCourse().getId()
        );
    }
}
