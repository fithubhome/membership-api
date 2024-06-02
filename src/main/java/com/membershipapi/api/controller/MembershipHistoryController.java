package com.membershipapi.api.controller;

import com.membershipapi.api.controller.dto.MembershipHistoryDTO;
import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.service.MembershipHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/membershipHistory")
public class MembershipHistoryController {

    @Autowired
    private MembershipHistoryService service;


    @GetMapping("/{id}")
    public ResponseEntity<MembershipHistory> getMembershipHistoryById(@PathVariable Long id) {
        Optional<MembershipHistory> membershipHistory = service.getMembershipHistoryById(id);
        if (membershipHistory.isPresent()) {
            return ResponseEntity.ok(membershipHistory.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MembershipHistory>> getMembershipHistoryByProfileId(@RequestParam(name = "profileId", required = false) Long profileId) {
        if (profileId == null) {
            return ResponseEntity.ok(service.getAllMembershipHistories());
        }
        List<MembershipHistory> membershipHistory = service.getMembershipHistoryByProfileId(profileId);
        return ResponseEntity.ok(membershipHistory);

    }


    @PostMapping
    public MembershipHistoryDTO createMembershipHistory(@RequestBody MembershipHistoryDTO membershipHistoryDTO) {

        return service.createMembershipHistory(membershipHistoryDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipHistory> updateMembershipHistory(@PathVariable Long id, @RequestBody MembershipHistoryDTO membershipHistoryDTO) {

        MembershipHistory updatedMembershipHistory = service.updateMembershipHistory(id, membershipHistoryDTO);
        if (updatedMembershipHistory != null) {
            return ResponseEntity.ok(updatedMembershipHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembershipHistory(@PathVariable Long id) {
        service.deleteMembershipHistory(id);
        return ResponseEntity.noContent().build();
    }
}
