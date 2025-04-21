package com.apollotechschool.ApolloTechSchool.services.impl;

/* CourseServiceImpl
 * Course Service Implementation
 * Establish Business Logic on DB interactions related to the Course Entity
 * */

// Allow the user to enroll, see enrolled courses, and un-enroll from them

import com.apollotechschool.ApolloTechSchool.entities.Course;
import com.apollotechschool.ApolloTechSchool.entities.CourseEnrolled;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityAlreadyExistsException;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.CoursePayload;
import com.apollotechschool.ApolloTechSchool.payloads.MessagePayload;
import com.apollotechschool.ApolloTechSchool.repositories.CourseEnrolledRepository;
import com.apollotechschool.ApolloTechSchool.repositories.CourseRepository;
import com.apollotechschool.ApolloTechSchool.repositories.UserRepository;
import com.apollotechschool.ApolloTechSchool.services.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final CourseEnrolledRepository courseEnrolledRepository;

    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository, CourseEnrolledRepository courseEnrolledRepository)
    {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.courseEnrolledRepository = courseEnrolledRepository;
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
                    null,
                    null
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
                null,
                null
        );
    }

    @Override
    public MessagePayload enrollUserInCourse(Long courseId, Long userId) {

        // First check the user and the course both exist
        if (!userRepository.existsById(userId) || !courseRepository.existsById(courseId))
        {
            throw new EntityNotFoundException("User or course not found");
        }

        // Check user is not already enrolled on this course
        if (courseEnrolledRepository.findByUserIdAndCourseId(userId, courseId).isPresent())
        {
            throw new EntityAlreadyExistsException("You are already enrolled in this course");
        }

        // Create new course enrollment
        CourseEnrolled courseEnrolled = new CourseEnrolled();

        courseEnrolled.setUser(userRepository.getReferenceById(userId));
        courseEnrolled.setCourse(courseRepository.getReferenceById(courseId));

        courseEnrolledRepository.save(courseEnrolled);

        return new MessagePayload("Successfully enrolled in course " + courseEnrolled.getCourse().getTitle());
    }

    @Override
    public CoursePayload getCourseOfUser(Long courseId, Long userId) {
        Optional<CourseEnrolled> courseEnrolledContainer = courseEnrolledRepository.findByUserIdAndCourseId(userId, courseId);

        if (courseEnrolledContainer.isEmpty())
        {
            throw new EntityNotFoundException("User is not enrolled to this course");
        }

        CourseEnrolled courseEnrolled = courseEnrolledContainer.get();

        // Get course associated to it
        Course course = courseEnrolled.getCourse();

        return new CoursePayload(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getPicUrl(),
                course.getLevel(),
                course.getCategory().getId(),
                null,
                null
        );
    }

    @Override
    public List<CoursePayload> getAllCourseOfUser(Long userId) {

        List<CourseEnrolled> enrolled = courseEnrolledRepository.findByUserId(userId);

        return enrolled.stream()
                .map(e -> {
                    Course course = e.getCourse();
                    return new CoursePayload(
                            course.getId(),
                            course.getTitle(),
                            course.getDescription(),
                            course.getPicUrl(),
                            course.getLevel(),
                            course.getCategory().getId(),
                            null,
                            null
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public MessagePayload unEnrollUserFromCourse(Long courseId, Long userId) {

        Optional<CourseEnrolled> enrolled = courseEnrolledRepository.findByUserIdAndCourseId(userId, courseId);

        if (enrolled.isEmpty())
        {
            throw new EntityNotFoundException("You are not enrolled in this course");
        }

        courseEnrolledRepository.delete(enrolled.get());
        return new MessagePayload("You successfully unenrolled from this course");
    }
}
