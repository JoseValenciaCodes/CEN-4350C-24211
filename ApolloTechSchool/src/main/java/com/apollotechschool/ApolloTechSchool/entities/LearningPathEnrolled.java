package com.apollotechschool.ApolloTechSchool.entities;

import jakarta.persistence.*;

/* Learning Path Enrolled Entity
* Represents learning paths the user is enrolled to
* */

@Entity
@Table(
        name = "learning_path_enrolled",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "learning_path_id"})
)
public class LearningPathEnrolled
{
    /* Learning Path Enrolled Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Learning Path Enrolled Relationships */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "learning_path_id", nullable = false, unique = true)
    private LearningPath learningPath;

    public LearningPathEnrolled() {}

    public LearningPathEnrolled(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LearningPath getLearningPath() {
        return learningPath;
    }

    public void setLearningPath(LearningPath learningPath) {
        this.learningPath = learningPath;
    }
}
