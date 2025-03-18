package com.apollotechschool.ApolloTechSchool.payloads;

/* CourseReviewPayload
 * Class that represents JSON Payload to return when the user asks for a CourseReview Data
 * */

public class CourseReviewPayload
{
    private Long id;
    private String name;
    private String picUrl;
    private String occupation;
    private String description;
    private Long userId;
    private Long courseId;

    public CourseReviewPayload() {}

    public CourseReviewPayload(Long id, String name, String picUrl, String occupation, String description, Long userId, Long courseId) {
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.occupation = occupation;
        this.description = description;
        this.userId = userId;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
