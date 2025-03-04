package com.apollotechschool.ApolloTechSchool.entities;

/* Course Module Entity
* Represents a course module of a course
* It's part of the course detailed description for the course details page
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Entity
@Table(name = "course_modules")
public class CourseModule
{
    /* Course Modules Attributes */
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @NotBlank(message = "Module title cannot be blank")
    @Column(name = "title", nullable = false)
    private String title;

    @Getter
    @NotBlank(message = "Module description cannot be blank")
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    /* Course Module Relationships*/
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public CourseModule() {}

    public CourseModule(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
