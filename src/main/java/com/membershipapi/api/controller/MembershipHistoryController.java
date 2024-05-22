package com.membershipapi.api.controller;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.service.MembershipHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membershipHistory")
public class MembershipHistoryController {

    @Autowired
    private MembershipHistoryService membershipHistoryService;

    @GetMapping
    public ResponseEntity<List<MembershipHistory>> viewMembershipHistories() {
        List<MembershipHistory> histories = membershipHistoryService.viewMembershipHistories();
        return ResponseEntity.status(HttpStatus.OK).body(histories);
    }

    @PostMapping
    public ResponseEntity<MembershipHistory> addMembership(@RequestBody MembershipType membershipType, @RequestParam int profileId) {
        try {
            MembershipHistory savedMembership = membershipHistoryService.addMembershipType(membershipType, profileId);
            // Logging can be done using a logger, assuming you have one configured
            System.out.println("Membership added successfully for profile ID: " + profileId);
            return new ResponseEntity<>(savedMembership, HttpStatus.CREATED);
        } catch (Exception e) {
            // Logging can be done using a logger, assuming you have one configured
            System.err.println("Failed to add membership for profile ID: " + profileId + ". Error: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
