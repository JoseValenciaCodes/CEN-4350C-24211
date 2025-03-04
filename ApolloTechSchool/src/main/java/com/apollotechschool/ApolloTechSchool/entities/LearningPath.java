package com.apollotechschool.ApolloTechSchool.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(
        name = "learning_paths",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "description"})
)
public class LearningPath
{
    /* Learning Path Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @NotBlank(message = "Description cannot be empty")
    @Column(name = "description", nullable = false, unique = true,  columnDefinition = "TEXT")
    private String description;

    @NotBlank(message = "Image URL cannot be empty")
    @Pattern(regexp = "^(http|https)://.*", message = "Invalid URL format")
    @Column(name = "pic_url", nullable = false)
    private String picUrl;

    /* Learning Path Relationships */
    @OneToMany(mappedBy = "learningPath", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

    @OneToMany(mappedBy = "learningPath", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LearningPathEnrolled> learningPathEnrolledList;

    public LearningPath() {}

    public LearningPath(Long id, String title, String description, String picUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<LearningPathEnrolled> getLearningPathEnrolledList() {
        return learningPathEnrolledList;
    }

    public void setLearningPathEnrolledList(List<LearningPathEnrolled> learningPathEnrolledList) {
        this.learningPathEnrolledList = learningPathEnrolledList;
    }
}
