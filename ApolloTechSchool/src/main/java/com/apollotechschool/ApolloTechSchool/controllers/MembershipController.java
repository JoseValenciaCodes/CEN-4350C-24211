package com.apollotechschool.ApolloTechSchool.controllers;

import com.apollotechschool.ApolloTechSchool.dtos.MembershipUserDto;
import com.apollotechschool.ApolloTechSchool.payloads.MembershipPayload;
import com.apollotechschool.ApolloTechSchool.payloads.MessagePayload;
import com.apollotechschool.ApolloTechSchool.services.MembershipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<MembershipPayload> getMembershipOfUser(@PathVariable("userId") Long userId)
    {
        MembershipPayload membershipPayload = membershipService.getMembershipOfUser(userId);
        return ResponseEntity.ok(membershipPayload);
    }

    @PostMapping
    public ResponseEntity<MessagePayload> addUserToMembership(@RequestBody MembershipUserDto membershipUserDto)
    {
        MessagePayload messagePayload = membershipService.addUserToMembership(membershipUserDto.getMembershipId(), membershipUserDto.getUserId());
        return ResponseEntity.ok(messagePayload);
    }

    @DeleteMapping
    public ResponseEntity<MessagePayload> deleteUserFromMembership(@RequestBody MembershipUserDto membershipUserDto)
    {
        MessagePayload messagePayload = membershipService.deleteUserFromMembership(membershipUserDto.getMembershipId(), membershipUserDto.getUserId());
        return ResponseEntity.ok(messagePayload);
    }
}
