package com.apollotechschool.ApolloTechSchool.services.impl;

import com.apollotechschool.ApolloTechSchool.entities.CourseReview;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.CourseReviewPayload;
import com.apollotechschool.ApolloTechSchool.repositories.CourseRepository;
import com.apollotechschool.ApolloTechSchool.repositories.CourseReviewRepository;
import com.apollotechschool.ApolloTechSchool.services.CourseReviewService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* CourseReviewServiceImpl
 * CourseReview Service Implementation
 * Establish Business Logic on DB interactions related to the CourseReview Entity
 * */
@Service
@Transactional
public class CourseReviewServiceImpl implements CourseReviewService
{
    public CourseRepository courseRepository;
    public CourseReviewRepository courseReviewRepository;

    public CourseReviewServiceImpl(CourseRepository courseRepository, CourseReviewRepository courseReviewRepository) {
        this.courseRepository = courseRepository;
        this.courseReviewRepository = courseReviewRepository;
    }

    @Override
    public List<CourseReviewPayload> getCourseReviewsByCourseId(Long courseId)
    {
        // Try to find the course first
        courseRepository.findById(courseId).orElseThrow(
                () -> new EntityNotFoundException("Course of id " + courseId + " could not be found")
        );

        // Find the reviews of this course
        List<CourseReview> courseReviews = courseReviewRepository.findAll().stream().filter(courseReview -> Objects.equals(courseReview.getCourse().getId(), courseId)).toList();
        List<CourseReviewPayload> courseReviewPayloads = new ArrayList<CourseReviewPayload>();

        for (CourseReview courseReview : courseReviews)
        {
            courseReviewPayloads.add(new CourseReviewPayload(
                    courseReview.getId(),
                    courseReview.getName(),
                    courseReview.getPicUrl(),
                    courseReview.getOccupation(),
                    courseReview.getDescription(),
                    courseReview.getUser().getId(),
                    courseReview.getCourse().getId()
            ));
        }

        return courseReviewPayloads;
    }

    @Override
    public CourseReviewPayload getCourseReviewById(Long courseReviewId)
    {

        CourseReview courseReview = courseReviewRepository.findById(courseReviewId).orElseThrow(
                () -> new EntityNotFoundException("Course Review of id " + courseReviewId + " could not be found")
        );

        return new CourseReviewPayload(
                courseReview.getId(),
                courseReview.getName(),
                courseReview.getPicUrl(),
                courseReview.getOccupation(),
                courseReview.getDescription(),
                courseReview.getUser().getId(),
                courseReview.getCourse().getId()
        );
    }
}
