package com.apollotechschool.ApolloTechSchool.payloads;

/* CourseRequirementPayload
 * Class that represents JSON Payload to return when the user asks for a CourseRequirement Data
 * */
public class CourseRequirementPayload
{
    private Long id;
    private String requirement;
    private Long courseId;
    public CourseRequirementPayload() {}
    public CourseRequirementPayload(Long id, String requirement, Long courseId) {
        this.id = id;
        this.requirement = requirement;
        this.courseId = courseId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
