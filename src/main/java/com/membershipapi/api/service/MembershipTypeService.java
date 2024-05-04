package com.membershipapi.api.service;

import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipTypeService {

    private final MembershipRepository membershipRepository;

    @Autowired
    public MembershipTypeService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    public List<MembershipType> getAllMemberships() {
        return membershipRepository.findAll();
    }

    public MembershipType getMembershipById(int id) {
        return membershipRepository.findById(id).orElse(null);
    }

    public MembershipType createMembership(MembershipType membershipType) {
        // VALIDATE that its not duplicate
        return membershipRepository.save(membershipType);
    }

    public MembershipType updateMembership(int id, MembershipType updatedMembershipType) {
        Optional<MembershipType> existingMembershipOptional = membershipRepository.findById(id);
        if (existingMembershipOptional.isPresent()) {
            MembershipType existingMembershipType = existingMembershipOptional.get();
            existingMembershipType.setName(updatedMembershipType.getName());
            return membershipRepository.save(existingMembershipType);
        } else {
            return null; // Handle error - membership not found
        }
    }

    public void deleteMembership(int id) {
        membershipRepository.deleteById(id);
    }
}
