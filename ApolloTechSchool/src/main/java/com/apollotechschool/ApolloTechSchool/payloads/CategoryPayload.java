package com.apollotechschool.ApolloTechSchool.payloads;

/* CategoryPayload
 * Class that represents JSON Payload to return when the user asks for Category Data
 * */

public class CategoryPayload
{
    // Attributes
    private Long id;
    private String name;

    public CategoryPayload() {}

    public CategoryPayload(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
