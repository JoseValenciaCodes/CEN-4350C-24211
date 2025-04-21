package com.apollotechschool.ApolloTechSchool.services;

/* MembershipService
* Contract to establish the methods of the Membership Service Implementation
* What the service does, what it returns, and the expected inputs are all managed from here
* */

import com.apollotechschool.ApolloTechSchool.payloads.MembershipPayload;
import com.apollotechschool.ApolloTechSchool.payloads.MessagePayload;

import java.util.List;

public interface MembershipService
{
    List<MembershipPayload> getAllMemberships();
    MembershipPayload getMembershipById(Long id);
    MembershipPayload getMembershipOfUser(Long userId);
    MessagePayload addUserToMembership(Long membershipId, Long userId);
    MessagePayload deleteUserFromMembership(Long membershipId, Long userId);
}
