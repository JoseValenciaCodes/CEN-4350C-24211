package com.apollotechschool.ApolloTechSchool.entities;

/*
* Course Packet Enrolled
* Represents a course packet the user has enrolled to
* */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "course_packet_enrolled",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "course_packet_id"})
)
public class CoursePacketEnrolled
{
    /* Course Packet Enrolled Attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Course Packet Enrolled Relationships */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_packet_id", nullable = false, unique = true)
    private CoursePacket coursePacket;
}
