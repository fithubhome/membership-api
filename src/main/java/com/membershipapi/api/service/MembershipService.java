package com.membershipapi.api.service;

import com.membershipapi.api.model.Membership;
import com.membershipapi.api.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;

    @Autowired
    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    public Membership getMembershipById(int id) {
        return membershipRepository.findById(id).orElse(null);
    }

    public Membership createMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    public Membership updateMembership(int id, Membership updatedMembership) {
        Optional<Membership> existingMembershipOptional = membershipRepository.findById(id);
        if (existingMembershipOptional.isPresent()) {
            Membership existingMembership = existingMembershipOptional.get();
            existingMembership.setName(updatedMembership.getName());
            return membershipRepository.save(existingMembership);
        } else {
            return null; // Handle error - membership not found
        }
    }

    public void deleteMembership(int id) {
        membershipRepository.deleteById(id);
    }
}
