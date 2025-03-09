package com.apollotechschool.ApolloTechSchool.payloads;

/* UserPayload
 * Represents JSON payload to return to the user when data about a user is requested
 * */

public class UserPayload
{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String picUrl;

    private String jwtToken;

    public UserPayload() {}

    public UserPayload(Long id, String firstName, String lastName, String email, String picUrl, String jwtToken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.picUrl = picUrl;
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
