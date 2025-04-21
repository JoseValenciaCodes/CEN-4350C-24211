package com.apollotechschool.ApolloTechSchool.dtos;

import jakarta.validation.constraints.NotBlank;

/* JSON Payload meant to carry the ID of a user and its associated membership */
public class MembershipUserDto
{
    private Long userId;
    private Long membershipId;

    public MembershipUserDto(Long userId, Long membershipId)
    {
        this.userId = userId;
        this.membershipId = membershipId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }
}
