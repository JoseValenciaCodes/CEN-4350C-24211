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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public CourseEnrolled() {}

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
