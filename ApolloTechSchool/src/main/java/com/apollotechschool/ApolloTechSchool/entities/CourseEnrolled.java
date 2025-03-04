package com.apollotechschool.ApolloTechSchool.entities;

/* Course Enrolled Entity
* Meant to keep track of the courses the user is enrolled in
* */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "course_enrolled",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "course_id"})
)
public class CourseEnrolled
{
    /* Course Enrolled Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Course Enrolled Relationships */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, unique = true)
    private Course course;

    public CourseEnrolled() {}

    public CourseEnrolled(Long id, User user) {
        this.id = id;
        this.user = user;
    }
}
