package com.apollotechschool.ApolloTechSchool.services.impl;

import com.apollotechschool.ApolloTechSchool.entities.CourseSkill;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.CourseSkillPayload;
import com.apollotechschool.ApolloTechSchool.repositories.CourseRepository;
import com.apollotechschool.ApolloTechSchool.repositories.CourseSkillRepository;
import com.apollotechschool.ApolloTechSchool.services.CourseSkillService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* CourseSkillServiceImpl
 * CourseSkill Service Implementation
 * Establish Business Logic on DB interactions related to the CourseSkill Entity
 * */
@Service
@Transactional
public class CourseSkillServiceImpl implements CourseSkillService
{
    public CourseRepository courseRepository;
    public CourseSkillRepository courseSkillRepository;

    public CourseSkillServiceImpl(CourseRepository courseRepository, CourseSkillRepository courseSkillRepository) {
        this.courseRepository = courseRepository;
        this.courseSkillRepository = courseSkillRepository;
    }

    @Override
    public List<CourseSkillPayload> getCourseSkillsByCourseId(Long courseId) {

        // Try to find the course first
        courseRepository.findById(courseId).orElseThrow(
                () -> new EntityNotFoundException("Course Skill of id " + courseId + " could not be found")
        );

        // Find the skills of this course
        List<CourseSkill> courseSkills = courseSkillRepository.findAll().stream().filter(courseSkill -> Objects.equals(courseSkill.getCourse().getId(), courseId)).toList();
        List<CourseSkillPayload> courseSkillPayloads = new ArrayList<CourseSkillPayload>();

        for (CourseSkill courseSkill : courseSkills)
        {
            courseSkillPayloads.add(new CourseSkillPayload(
                    courseSkill.getId(),
                    courseSkill.getSkill(),
                    courseSkill.getCourse().getId()
            ));
        }

        return courseSkillPayloads;
    }

    @Override
    public CourseSkillPayload getCourseSkillById(Long courseSkillId) {

        CourseSkill courseSkill = courseSkillRepository.findById(courseSkillId).orElseThrow(
                () -> new EntityNotFoundException("Course Skill of id " + courseSkillId + " could not be found")
        );

        return new CourseSkillPayload(
                courseSkill.getId(),
                courseSkill.getSkill(),
                courseSkill.getCourse().getId()
        );
    }
}
