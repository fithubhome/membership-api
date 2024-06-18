package com.membershipapi.api.controller;

import com.membershipapi.api.controller.dto.MembershipHistoryDTO;
import com.membershipapi.api.exception.EntityNotFoundException;
import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.service.MembershipHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/membershipHistory")
public class MembershipHistoryController {

    @Autowired
    private MembershipHistoryService membershipHistoryService;

    @GetMapping("/{id}")
    public ResponseEntity<MembershipHistory> getMembershipHistoryById(@PathVariable UUID id) {
        Optional<MembershipHistory> membershipHistory = membershipHistoryService.getMembershipHistoryById(id);
        if (membershipHistory.isPresent()) {
            return ResponseEntity.ok(membershipHistory.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MembershipHistory>> getMembershipHistoryByProfileId(@RequestParam(name = "profileId", required = false) UUID profileId) {
        if (profileId == null) {
            return ResponseEntity.ok(membershipHistoryService.getAllMembershipHistories());
        }
        List<MembershipHistory> membershipHistory = membershipHistoryService.getMembershipHistoryByProfileId(profileId);
        return ResponseEntity.ok(membershipHistory);
    }

//__________TO REVIEW_________________
    @PostMapping
    public MembershipHistoryDTO createMembershipHistory(@RequestBody MembershipHistoryDTO membershipHistoryDTO) {
        return membershipHistoryService.createMembershipHistory(membershipHistoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipHistory> updateMembershipHistory(@RequestBody MembershipHistoryDTO membershipHistoryDTO) {
        try {
            MembershipHistory updatedMembershipHistory = membershipHistoryService.updateMembershipHistory(membershipHistoryDTO);
            return ResponseEntity.ok(updatedMembershipHistory);
        } catch (EntityNotFoundException ex){
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembershipHistory(@PathVariable UUID id) {
        membershipHistoryService.deleteMembershipHistory(id);
        return ResponseEntity.noContent().build();
    }
}
