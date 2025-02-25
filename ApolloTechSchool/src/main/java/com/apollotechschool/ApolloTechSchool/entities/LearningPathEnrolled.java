package com.apollotechschool.ApolloTechSchool.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Learning Path Enrolled Entity
* Represents learning paths the user is enrolled to
* */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
