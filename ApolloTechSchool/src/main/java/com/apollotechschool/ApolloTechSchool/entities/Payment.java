package com.apollotechschool.ApolloTechSchool.entities;

/*
* Payment class
* Meant to represent a payment made for a course/membership subscription
* Stores a payment instance in the DB
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment
{
    /* Payment attributes */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin(value = "20.00", message = "Payment amount cannot be less than 20.00")
    @Column(name = "amount", nullable = false)
    private Double amount;

    @NotNull(message = "Payment status cannot be null")
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull(message = "Payment metnod cannot be null")
    @Column(name = "method", nullable = false)
    private String method;

    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Invalid transaction ID format")
    @Column(name = "transaction_id", unique = true)
    private String transactionId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Initialize createdAt attribute as soon as a payment is made
    @PrePersist
    protected void onCreate()
    {
        this.createdAt = LocalDateTime.now();
    }

    /* Payment Relationships */
    @NotNull(message = "Order cannot be null")
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;
}
