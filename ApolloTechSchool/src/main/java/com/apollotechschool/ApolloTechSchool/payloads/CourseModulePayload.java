package com.apollotechschool.ApolloTechSchool.payloads;


/* CourseModulePayload
 * Class that represents JSON Payload to return when the user asks for a CourseModule Data
 * */
public class CourseModulePayload
{
    private Long id;
    private String title;
    private String description;
    private Long courseId;

    public CourseModulePayload() {}

    public CourseModulePayload(Long id, String title, String description, Long courseId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.courseId = courseId;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
