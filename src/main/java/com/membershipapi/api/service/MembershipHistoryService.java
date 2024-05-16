package com.membershipapi.api.service;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.repository.MembershipHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipHistoryService {

    @Autowired
    private MembershipHistoryRepository membershipHistoryRepository;

    public List<MembershipHistory> viewMembershipHistories() {
        return membershipHistoryRepository.getMembershipHistoriesList();
    }

    public MembershipHistory addMembershipType(MembershipType membershipType, int profileId) {
       //TODO :  CHeck if profileID is in the database





        // TODO : Check if profile ID has other running memberships

    }
}
