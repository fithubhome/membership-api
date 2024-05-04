package com.membershipapi.api.service;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.repository.MembershipHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipHistoryService {

    private final MembershipHistoryRepository membershipHistoryRepository;

    public MembershipHistoryService(MembershipHistoryRepository membershipHistoryRepository) {
        this.membershipHistoryRepository = membershipHistoryRepository;
    }


    public List<MembershipHistory> getMembershipHistory(Integer userId) {
        return MembershipHistoryRepository.getMembershipHistory(userId);
    }


    public MembershipHistory createMembershipHistory(MembershipHistory membershipHistory) {
        // Perform local validation

        return membershipHistoryRepository.add(membershipHistory);
    }
}
