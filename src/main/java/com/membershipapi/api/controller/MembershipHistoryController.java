package com.membershipapi.api.controller;

import com.membershipapi.api.exception.EntityAllreadyExistsException;
import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.service.MembershipHistoryService;
import com.membershipapi.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membershiphistory")
public class MembershipHistoryController {

    @Autowired
    private MembershipHistoryService membershipHistoryService;

    @GetMapping
    public ResponseEntity<List<MembershipHistory>> viewMembershipHistories() {
        List<MembershipHistory> histories = membershipHistoryService.viewMembershipHistories();

        return ResponseEntity.status(200).body(histories);

//        return histories.map(history -> ResponseEntity.status(200).body(history))
//                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    @PostMapping
    public ResponseEntity<MembershipHistory> addMembership(@RequestBody MembershipType membershipType, @RequestParam int profileId) {
        try {
            MembershipHistory savedMembership = membershipHistoryService.addMembershipType(membershipType, profileId);
            Logger.logInfo("Membership added successfully for profile ID: " + profileId);
            return new ResponseEntity<>(savedMembership, HttpStatus.CREATED);
        } catch (Exception e) {
            Logger.logError("Failed to add membership for profile ID: " + profileId + ". Error: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
