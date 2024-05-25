package com.membershipapi.api.controller;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.service.MembershipHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/membershipHistories")
public class MembershipHistoryController {

    @Autowired
    private MembershipHistoryService service;

    @GetMapping
    public List<MembershipHistory> getAllMembershipHistories() {
        return service.getAllMembershipHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipHistory> getMembershipHistoryById(@PathVariable Long id) {
        Optional<MembershipHistory> membershipHistory = service.getMembershipHistoryById(id);
        if (membershipHistory.isPresent()) {
            return ResponseEntity.ok(membershipHistory.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MembershipHistory createMembershipHistory(@RequestBody MembershipHistory membershipHistory) {
        return service.createMembershipHistory(membershipHistory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipHistory> updateMembershipHistory(@PathVariable Long id, @RequestBody MembershipHistory membershipHistory) {
        MembershipHistory updatedMembershipHistory = service.updateMembershipHistory(id, membershipHistory);
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
