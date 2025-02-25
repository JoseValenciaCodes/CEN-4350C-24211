package com.apollotechschool.ApolloTechSchool.entities;

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
        name = "course_packets",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "description"})
)
public class CoursePacket
{
    /* Course Packet Attributes */
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

    /* Course Packet Relationships */
    @OneToMany(mappedBy = "coursePacket")
    private List<Course> courses;

    @OneToMany(mappedBy = "coursePacket")
    private List<CoursePacketEnrolled> coursePacketEnrolledList;

}
