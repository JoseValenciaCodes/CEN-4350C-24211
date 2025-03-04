package com.apollotechschool.ApolloTechSchool.payloads;

/* CoursePacket Payload
* Class that represents JSON payload to return when user requests data on CoursePacket Entity
* */

public class CoursePacketPayload
{
    private Long id;
    private String title;
    private String description;
    private String picUrl;
    public CoursePacketPayload() {}

    public CoursePacketPayload(Long id, String title, String description, String picUrl) {
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
