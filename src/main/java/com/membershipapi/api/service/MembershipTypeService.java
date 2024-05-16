package com.membershipapi.api.service;

import com.membershipapi.api.exception.EntityAllreadyExistsException;
import com.membershipapi.api.exception.EntityNotFoundException;
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
        return membershipRepository.findAllMbTypes();
    }

    public MembershipType getMembershipById(int id) throws EntityNotFoundException {
        return membershipRepository.findMbTypeById(id).orElse(null);
    }

    public MembershipType createMembership(MembershipType membershipType) throws EntityAllreadyExistsException {
        return membershipRepository.createMembership(membershipType);
    }

    public MembershipType updateMembership(int id, MembershipType updatedMembershipType) throws EntityNotFoundException {
        Optional<MembershipType> existingMembershipOptional = membershipRepository.findMbTypeById(id);
        if (existingMembershipOptional.isPresent()) {
            MembershipType existingMembershipType = existingMembershipOptional.get();
            existingMembershipType.setName(updatedMembershipType.getName());
            existingMembershipType.setPrice(updatedMembershipType.getPrice());

            return existingMembershipType;
        } else {
            return null; // Handle error - membership not found
        }
    }

    public void deleteMembership(int id) throws EntityNotFoundException {
        membershipRepository.deleteMbTypeById(id);
    }
}
