package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.payloads.MembershipPayload;
import com.apollotechschool.ApolloTechSchool.services.MembershipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* MembershipController
* Handle HTTP Requests related to the Membership Entity
* */
@RestController
@RequestMapping("/api/memberships")
public class MembershipController
{
    private MembershipService membershipService;

    public MembershipController(MembershipService membershipService)
    {
        this.membershipService = membershipService;
    }

    @GetMapping
    public ResponseEntity<List<MembershipPayload>> getAllMemberships()
    {
        List<MembershipPayload> membershipPayloads = membershipService.getAllMemberships();
        return ResponseEntity.ok(membershipPayloads);
    }

    @GetMapping("{id}")
    public ResponseEntity<MembershipPayload> getMembershipById(@PathVariable("id") Long id)
    {
        MembershipPayload membershipPayload = membershipService.getMembershipById(id);
        return ResponseEntity.ok(membershipPayload);
    }
}
