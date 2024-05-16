package com.membershipapi.api.controller;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.service.MembershipHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
