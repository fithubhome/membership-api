package com.membershipapi.api.service;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.repository.MembershipHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MembershipHistoryService {

    @Autowired
    private MembershipHistoryRepository membershipHistoryRepository;

    public List<MembershipHistory> viewMembershipHistories() {
        return membershipHistoryRepository.findAll();
    }

    public MembershipHistory addMembershipType(MembershipType membershipType, int profileId) {
        MembershipHistory membershipHistory = new MembershipHistory();
        membershipHistory.setProfileId(profileId);
        membershipHistory.setMembershipType(membershipType);
        membershipHistory.setStartDate(new Date()); // Set start date to current date
        // You can add logic to set end date if needed
        return membershipHistoryRepository.save(membershipHistory);
    }
}
