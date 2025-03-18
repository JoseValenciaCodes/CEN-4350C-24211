package com.apollotechschool.ApolloTechSchool.payloads;

/* CourseSkillPayload
 * Class that represents JSON Payload to return when the user asks for a CourseSkill Data
 * */
public class CourseSkillPayload
{
    private Long id;
    private String skill;
    private Long courseId;
    public CourseSkillPayload() {}
    public CourseSkillPayload(Long id, String skill, Long courseId) {
        this.id = id;
        this.skill = skill;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
