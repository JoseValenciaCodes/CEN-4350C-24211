package com.apollotechschool.ApolloTechSchool.payloads;

/* CoursePayload
* Class that represents JSON Payload to return when the user asks for Course Data
* */

public class CoursePayload
{
    // Attributes
    private Long id;
    private String title;
    private String description;
    private String picUrl;
    private String level;

    // Foreign keys
    private Long categoryId;
    private Long coursePacketId;
    private Long learningPathId;

    public CoursePayload() {}

    public CoursePayload(Long id, String title, String description, String picUrl, String level, Long categoryId, Long coursePacketId, Long learningPathId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.level = level;
        this.categoryId = categoryId;
        this.coursePacketId = coursePacketId;
        this.learningPathId = learningPathId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getLevel() {
        return level;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getCoursePacketId() {
        return coursePacketId;
    }

    public Long getLearningPathId() {
        return learningPathId;
    }
}
