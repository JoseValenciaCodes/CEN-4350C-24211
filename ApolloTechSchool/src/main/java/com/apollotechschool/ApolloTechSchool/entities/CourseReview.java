package com.apollotechschool.ApolloTechSchool.entities;

/*
* Course Review Entity
* Meant to represent course reviews users submit to the app
* Stores a course review in the DB
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course_reviews")
public class CourseReview
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Profile picture URL cannot be empty")
    @Pattern(regexp = "^(http|https)://.*", message = "Invalid URL format")
    @Column(name = "pic_url", nullable = false)
    private String picUrl;

    @NotBlank(message = "Occupation cannot be empty")
    @Column(name = "occupation", nullable = false)
    private String occupation;

    @NotBlank(message = "Review description cabbot be empty")
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @DecimalMin(value = "1.0", message = "Rating must be at least 1.0")
    @DecimalMax(value = "5.0", message = "Rating cannot exceed 5.0")
    @Column(name = "rating", nullable = false)
    private Integer rating;

    /* Course Review Relationships */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
