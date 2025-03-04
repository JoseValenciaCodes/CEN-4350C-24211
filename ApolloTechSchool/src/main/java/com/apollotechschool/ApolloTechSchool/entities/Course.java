package com.apollotechschool.ApolloTechSchool.entities;

/*
* Course Entity
* Represent a course in the DB
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

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

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CourseReview> courseReviews;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CourseSkill> courseSkills;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CourseRequirement> courseRequirements;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CourseEnrolled> courseEnrolledList;
    public Course() {}

    public Course(Long id, String title, String description, String picUrl, String level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CoursePacket getCoursePacket() {
        return coursePacket;
    }

    public void setCoursePacket(CoursePacket coursePacket) {
        this.coursePacket = coursePacket;
    }

    public LearningPath getLearningPath() {
        return learningPath;
    }

    public void setLearningPath(LearningPath learningPath) {
        this.learningPath = learningPath;
    }

    public List<CourseReview> getCourseReviews() {
        return courseReviews;
    }

    public void setCourseReviews(List<CourseReview> courseReviews) {
        this.courseReviews = courseReviews;
    }

    public List<CourseSkill> getCourseSkills() {
        return courseSkills;
    }

    public void setCourseSkills(List<CourseSkill> courseSkills) {
        this.courseSkills = courseSkills;
    }

    public List<CourseRequirement> getCourseRequirements() {
        return courseRequirements;
    }

    public void setCourseRequirements(List<CourseRequirement> courseRequirements) {
        this.courseRequirements = courseRequirements;
    }

    public List<CourseEnrolled> getCourseEnrolledList() {
        return courseEnrolledList;
    }

    public void setCourseEnrolledList(List<CourseEnrolled> courseEnrolledList) {
        this.courseEnrolledList = courseEnrolledList;
    }
}
