package com.apollotechschool.ApolloTechSchool.entities;

/* Category Entity
* Represents a course category stored in the DB
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name cannot be empty")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /* Category Relationships */
    @OneToMany(mappedBy = "category")
    private List<Course> courses;
}
