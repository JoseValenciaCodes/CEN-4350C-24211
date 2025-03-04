package com.apollotechschool.ApolloTechSchool.entities;

/* OrderItem Entity
* Represent an item that has been bought through an order
* */

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "order_item")
public class OrderItem
{
    /* Order Item Attribute */
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @NotBlank(message = "Item type cannot be blank")
    @Column(name = "item_type", nullable = false)
    private String itemType;

    @Getter
    @NotNull(message = "Item ID cannot be null")
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Getter
    @DecimalMin(value = "20.00", message = "Price cannot be less than 20.00")
    @Column(name = "price", nullable = false)
    private Double price;

    /* Order Item Relationships */
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public OrderItem() {}

    public OrderItem(Long id, String itemType, Long itemId, Double price) {
        this.id = id;
        this.itemType = itemType;
        this.itemId = itemId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getItemType() {
        return itemType;
    }

    public Long getItemId() {
        return itemId;
    }

    public Double getPrice() {
        return price;
    }

    public Order getOrder() {
        return order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
