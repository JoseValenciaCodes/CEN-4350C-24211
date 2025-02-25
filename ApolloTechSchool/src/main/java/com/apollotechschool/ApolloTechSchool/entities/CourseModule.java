package com.apollotechschool.ApolloTechSchool.entities;

/* Course Module Entity
* Represents a course module of a course
* It's part of the course detailed description for the course details page
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course_modules")
public class CourseModule
{
    /* Course Modules Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Module title cannot be blank")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "Module description cannot be blank")
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    /* Course Module Relationships*/
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
