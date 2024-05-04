package com.membershipapi.api.controller;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.service.MembershipHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membershipHistory")
public class MembershipHistoryController {

    private final MembershipHistoryService membershipHistoryService;

    @Autowired
    public MembershipHistoryController(MembershipHistoryService membershipHistoryService) {
        this.membershipHistoryService = membershipHistoryService;
    }


    @PostMapping()
    public MembershipHistory addMembershipHistory(@RequestBody MembershipHistory membershipHistory) {
        membershipHistoryService.createMembershipHistory(membershipHistory);
        return membershipHistory;
    }

    @GetMapping()
    public List<MembershipHistory> getMembershipHistory(@RequestParam Integer userId) {
        List<MembershipHistory> membershipHistory = membershipHistoryService.getMembershipHistory(userId);
        return membershipHistory;
    }
}