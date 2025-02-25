package com.apollotechschool.ApolloTechSchool.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/* User Entity Class
* Represents a user stored in the DB
* */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<CourseReview> courseReviews;

    @OneToMany(mappedBy = "user")
    private List<CourseEnrolled> courseEnrolledList;

    @OneToMany(mappedBy = "user")
    private List<CoursePacketEnrolled> coursePacketEnrolledList;

    @OneToMany(mappedBy = "user")
    private List<LearningPathEnrolled> learningPathEnrolledList;

}
