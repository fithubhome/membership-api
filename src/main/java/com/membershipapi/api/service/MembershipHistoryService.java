package com.membershipapi.api.service;

import com.membershipapi.api.controller.dto.MembershipHistoryDTO;
import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.repository.MembershipHistoryRepository;
import com.membershipapi.api.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MembershipHistoryService {

    @Autowired(required = true)
    private MembershipHistoryRepository repository;
    @Autowired
    private MembershipTypeRepository membershipTypeRepository;


    public List<MembershipHistory> getAllMembershipHistories() {
        return repository.findAll();
    }

    public Optional<MembershipHistory> getMembershipHistoryById(UUID id) {
        return repository.findById(id);
    }

    public MembershipHistoryDTO createMembershipHistory(MembershipHistoryDTO membershipHistoryDTO) {

        MembershipHistory membershipHistory = new MembershipHistory();
        membershipHistory.setPayment(membershipHistoryDTO.getPayment());
        //MAKE Validation for profileID -
        membershipHistory.setProfileId(membershipHistoryDTO.getProfileId());
        membershipHistory.setStartDate(membershipHistoryDTO.getStartDate());
        membershipHistory.setEndDate(membershipHistoryDTO.getEndDate());

        //MAKE VALIDATION FOR MEMBERSHIP TYPE
        Optional<MembershipType> type = membershipTypeRepository.findById(membershipHistoryDTO.getMembershipTypeID());
        if(type.isEmpty())
            throw new RuntimeException("The wrong type was provided");

        membershipHistory.setMembershipType(type.get());
        repository.save(membershipHistory);
        return membershipHistoryDTO;

    }

    public MembershipHistory updateMembershipHistory(UUID id, MembershipHistoryDTO membershipHistoryDTO) {
        if (repository.existsById(id)) {

            MembershipHistory membershipHistory = new MembershipHistory();
            membershipHistory.setPayment(membershipHistoryDTO.getPayment());
            membershipHistory.setProfileId(membershipHistoryDTO.getProfileId());
            membershipHistory.setStartDate(membershipHistoryDTO.getStartDate());
            membershipHistory.setEndDate(membershipHistoryDTO.getEndDate());
            membershipHistory.setId(id);
            return repository.save(membershipHistory);
        } else {
            return null;
        }
    }

    public void deleteMembershipHistory(UUID id) {
        repository.deleteById(id);
    }


    public List<MembershipHistory> getMembershipHistoryByProfileId(UUID profileId) {
        return repository.findByProfileId(profileId);
//        return repository.findAllById(Collections.singleton(profileId)); -> in this method I have  commented the line in MembershipHistoryRepository
    }
}
