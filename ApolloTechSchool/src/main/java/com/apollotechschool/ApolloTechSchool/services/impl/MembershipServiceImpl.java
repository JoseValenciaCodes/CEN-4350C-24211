package com.apollotechschool.ApolloTechSchool.services.impl;

/* MembershipServiceImpl
* Membership Service Implementation
* Establish Business Logic on DB interactions related to the Membership Entity
* */

import com.apollotechschool.ApolloTechSchool.entities.Membership;
import com.apollotechschool.ApolloTechSchool.entities.User;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.MembershipPayload;
import com.apollotechschool.ApolloTechSchool.payloads.MessagePayload;
import com.apollotechschool.ApolloTechSchool.repositories.MembershipRepository;
import com.apollotechschool.ApolloTechSchool.repositories.UserRepository;
import com.apollotechschool.ApolloTechSchool.services.MembershipService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService
{
    private MembershipRepository membershipRepository;
    private UserRepository userRepository;

    public MembershipServiceImpl(MembershipRepository membershipRepository, UserRepository userRepository)
    {
        this.membershipRepository = membershipRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<MembershipPayload> getAllMemberships()
    {
        List<Membership> memberships = membershipRepository.findAll();
        List<MembershipPayload> membershipPayloads= new ArrayList<MembershipPayload>();

        for (Membership membership : memberships)
        {
            membershipPayloads.add(new MembershipPayload(
                    membership.getId(),
                    membership.getTitle(),
                    membership.getDescription(),
                    membership.getPrice()
            ));
        }

        return membershipPayloads;
    }

    @Override
    public MembershipPayload getMembershipById(Long id)
    {
        Membership membership = membershipRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Membership of id " + id + " could not be found")
        );

        return new MembershipPayload(
                membership.getId(),
                membership.getTitle(),
                membership.getDescription(),
                membership.getPrice()
        );
    }

    @Override
    public MembershipPayload getMembershipOfUser(Long userId) {
        // Try to find the user
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("The user could not be found")
        );

        // Now find the membership associated to this user
        Membership membership = user.getMembership();

        if (membership == null)
        {
            throw new EntityNotFoundException("User has no memberships");
        }

        return new MembershipPayload(
                membership.getId(),
                membership.getTitle(),
                membership.getDescription(),
                membership.getPrice()
        );
    }

    @Override
    public MessagePayload addUserToMembership(Long membershipId, Long userId) {

        // Get membership
        Membership membership = membershipRepository.findById(membershipId).orElseThrow(
                () -> new EntityNotFoundException("Membership of id " + membershipId + " could not be found")
        );

        // Get user
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("The user could not be found")
        );

        // Check if the user is enrolled in no membership
        if (user.getMembership() != null) {
            throw new EntityNotFoundException("User is already enrolled in a membership plan");
        }

        // Add the user to the membership
        user.setMembership(membership);

        // Return message
        return new MessagePayload("You successfully enrolled to the " + membership.getTitle() + " membership");
    }

    @Override
    public MessagePayload deleteUserFromMembership(Long membershipId, Long userId) {

        // Get membership
        membershipRepository.findById(membershipId).orElseThrow(
                () -> new EntityNotFoundException("Membership of id " + membershipId + " could not be found")
        );

        // Get user
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("The user could not be found")
        );

        // Remove the membership of this user
        user.setMembership(null);

        return new MessagePayload("Membership was successfully removed");
    }
}
