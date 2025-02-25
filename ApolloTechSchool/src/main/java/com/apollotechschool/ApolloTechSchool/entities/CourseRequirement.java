package com.apollotechschool.ApolloTechSchool.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
* Course Requirements Entity
* Stores a requirement for a specific course
* Meant to be used in a course's detail page
*
* */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
