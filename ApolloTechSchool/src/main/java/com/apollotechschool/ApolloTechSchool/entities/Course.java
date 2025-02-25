package com.apollotechschool.ApolloTechSchool.entities;

/*
* Course Entity
* Represent a course in the DB
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "courses",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "description"})
)
public class Course
{
    /* Course Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @NotBlank(message = "Decription cannot be empty")
    @Column(name = "description", nullable = false, unique = true,  columnDefinition = "TEXT")
    private String description;

    @NotBlank(message = "Image URL cannot be empty")
    @Pattern(regexp = "^(http|https)://.*", message = "Invalid URL Format")
    private String picUrl;

    @NotBlank(message = "Level cannot be empty")
    @Column(name = "level", nullable = false)
    private String level;

    /* Course Relationships */
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "course_packet_id", referencedColumnName = "id", nullable = true)
    private CoursePacket coursePacket;

    @ManyToOne
    @JoinColumn(name = "learning_path_id", referencedColumnName = "id", nullable = true)
    private LearningPath learningPath;

    @OneToMany(mappedBy = "course")
    private List<CourseReview> courseReviews;

    @OneToMany(mappedBy = "course")
    private List<CourseSkill> courseSkills;

    @OneToMany(mappedBy = "course")
    private List<CourseRequirement> courseRequirements;

    @OneToMany(mappedBy = "course")
    private List<CourseEnrolled> courseEnrolledList;
}
