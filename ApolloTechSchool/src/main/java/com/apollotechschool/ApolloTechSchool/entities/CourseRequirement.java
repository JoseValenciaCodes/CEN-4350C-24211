package com.apollotechschool.ApolloTechSchool.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/*
* Course Requirements Entity
* Stores a requirement for a specific course
* Meant to be used in a course's detail page
*
* */

@Entity
@Table(name = "course_requirements")
public class CourseRequirement
{
    /* Course Requirement attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Requirement cannot be empty")
    @Column(name = "requirement", nullable = false)
    private String requirement;

    /* Course Requirement Relationships*/
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public CourseRequirement() {}

    public CourseRequirement(Long id, String requirement) {
        this.id = id;
        this.requirement = requirement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
