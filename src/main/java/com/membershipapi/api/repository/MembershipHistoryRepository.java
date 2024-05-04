package com.membershipapi.api.repository;

import com.membershipapi.api.model.MembershipHistory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MembershipHistoryRepository {

    private static final List<MembershipHistory> membershipHistoryDatabase = new ArrayList<>();

    public static List<MembershipHistory> getMembershipHistory(Integer userId) {
        List<MembershipHistory> userMembershipHistory = new ArrayList<>();
        for (MembershipHistory membershipHistory : membershipHistoryDatabase) {
            if (membershipHistory.getProfileId() == userId) {
                userMembershipHistory.add(membershipHistory);
            }
        }
        return userMembershipHistory;
    }


    public MembershipHistory add(MembershipHistory membershipHistory) {
        // You may want to generate an ID or perform additional operations before saving
        membershipHistoryDatabase.add(membershipHistory);
        return membershipHistory;
    }

}


