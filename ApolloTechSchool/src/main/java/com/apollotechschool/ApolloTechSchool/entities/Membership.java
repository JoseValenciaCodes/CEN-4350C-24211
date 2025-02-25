package com.apollotechschool.ApolloTechSchool.entities;

/* Membership Entity
* Represents a Membership stored in the DB
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "memberships")
public class Membership
{
    /* Define Membership Atrributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @Column(name = "description", nullable = false,  columnDefinition = "TEXT")
    private String description;

    @NotBlank(message = "Price cannot be blank")
    @DecimalMin(value = "12.00", message = "Price must be at least 20.00")
    private Double price;

    /* Define Membership Relationships */
    @OneToMany(mappedBy = "membership")
    private List<User> users;
}
