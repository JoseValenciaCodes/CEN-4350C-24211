package com.apollotechschool.ApolloTechSchool.services.impl;

/* MembershipServiceImpl
* Membership Service Implementation
* Establish Business Logic on DB interactions related to the Membership Entity
* */

import com.apollotechschool.ApolloTechSchool.entities.Membership;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.MembershipPayload;
import com.apollotechschool.ApolloTechSchool.repositories.MembershipRepository;
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

    public MembershipServiceImpl(MembershipRepository membershipRepository)
    {
        this.membershipRepository = membershipRepository;
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
}
