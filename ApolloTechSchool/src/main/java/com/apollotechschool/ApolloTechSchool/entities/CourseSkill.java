package com.apollotechschool.ApolloTechSchool.entities;

/* Course Skill Entity
* Represents a skill associated to a certain course */

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
}
