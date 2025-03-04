package com.apollotechschool.ApolloTechSchool.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

/* User Entity Class
* Represents a user stored in the DB
* */

@Entity
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User
{
    /* Define User Attributes */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "^[A-Za-z]+(\\\\s[A-Za-z]+)*$", message = "First name may only contain letters and spaces")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "^[A-Za-z]+(\\\\s[A-Za-z]+)*$", message = "Last name may contain only letters and spaces")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "^(http|https)://.*", message = "Invalid URL Format")
    @Column(name = "pic_url", nullable = true)
    private String picUrl;

    @NotBlank(message = "Password cannot be empty")
    @Column(name = "password", nullable = false)
    private String password;

    /* Define User Relationships */
    @ManyToOne
    @JoinColumn(name = "membership_id", referencedColumnName = "id", nullable = true)
    private Membership membership;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseReview> courseReviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseEnrolled> courseEnrolledList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CoursePacketEnrolled> coursePacketEnrolledList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LearningPathEnrolled> learningPathEnrolledList;

    public User() {}

    public User(Long id, String firstName, String lastName, String email, String picUrl, String password, Membership membership) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.picUrl = picUrl;
        this.password = password;
        this.membership = membership;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<CourseReview> getCourseReviews() {
        return courseReviews;
    }

    public void setCourseReviews(List<CourseReview> courseReviews) {
        this.courseReviews = courseReviews;
    }

    public List<CourseEnrolled> getCourseEnrolledList() {
        return courseEnrolledList;
    }

    public void setCourseEnrolledList(List<CourseEnrolled> courseEnrolledList) {
        this.courseEnrolledList = courseEnrolledList;
    }

    public List<CoursePacketEnrolled> getCoursePacketEnrolledList() {
        return coursePacketEnrolledList;
    }

    public void setCoursePacketEnrolledList(List<CoursePacketEnrolled> coursePacketEnrolledList) {
        this.coursePacketEnrolledList = coursePacketEnrolledList;
    }

    public List<LearningPathEnrolled> getLearningPathEnrolledList() {
        return learningPathEnrolledList;
    }

    public void setLearningPathEnrolledList(List<LearningPathEnrolled> learningPathEnrolledList) {
        this.learningPathEnrolledList = learningPathEnrolledList;
    }
}
