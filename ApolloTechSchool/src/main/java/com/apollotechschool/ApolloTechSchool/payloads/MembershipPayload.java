package com.apollotechschool.ApolloTechSchool.payloads;

/* MembershipPayload
* Represents JSON payload to return to the user when data about a membership is requested
* */

public class MembershipPayload
{
    // Membership attributes to return
    private Long id;
    private String title;
    private String description;
    private Double price;

    public MembershipPayload() {}

    public MembershipPayload(Long id, String title, String description, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
