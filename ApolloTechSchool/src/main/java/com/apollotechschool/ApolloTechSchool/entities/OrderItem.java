package com.apollotechschool.ApolloTechSchool.entities;

/* OrderItem Entity
* Represent an item that has been bought through an order
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_item")
public class OrderItem
{
    /* Order Item Attribute */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Item type cannot be blank")
    @Column(name = "item_type", nullable = false)
    private String itemType;

    @NotNull(message = "Item ID cannot be null")
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @DecimalMin(value = "20.00", message = "Price cannot be less than 20.00")
    @Column(name = "price", nullable = false)
    private Double price;

    /* Order Item Relationships */
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
