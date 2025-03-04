package com.apollotechschool.ApolloTechSchool.entities;

/* Course Skill Entity
* Represents a skill associated to a certain course */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "course_skills")
public class CourseSkill
{
    /* Course Skill attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Skill cannot be empty")
    @Column(name = "skill", nullable = false)
    private String skill;

    /* Course Skill Relationships */
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public CourseSkill() {}

    public CourseSkill(Long id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
