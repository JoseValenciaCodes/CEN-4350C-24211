package com.apollotechschool.ApolloTechSchool.payloads;

/* LearningPath Payload
 * Class that represents JSON payload to return when user requests data on LearningPath Entity
 * */


public class LearningPathPayload
{
    private Long id;
    private String title;
    private String description;
    private String picUrl;

    public LearningPathPayload() {}

    public LearningPathPayload(Long id, String title, String description, String picUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
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
}
