package com.membershipapi.api.service;

import com.membershipapi.api.exception.EntityAllreadyExistsException;
import com.membershipapi.api.exception.EntityNotFoundException;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.repository.MembershipRepository;
import com.membershipapi.api.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MembershipTypeService {

    private final MembershipTypeRepository membershipTypeRepository;

    private final MembershipRepository membershipRepository;

    @Autowired
    public MembershipTypeService(MembershipTypeRepository membershipTypeRepository, MembershipRepository membershipRepository) {
        this.membershipTypeRepository = membershipTypeRepository;
        this.membershipRepository = membershipRepository;
    }

    public List<MembershipType> getAllMemberships() {

        return membershipTypeRepository.findAll();
    }

    public Optional<MembershipType> getMembershipById(UUID id) throws EntityNotFoundException {

        return membershipTypeRepository.findById(id);
    }

    public MembershipType createMembership(MembershipType membershipType) throws EntityAllreadyExistsException {
        List<MembershipType> allTypes =  membershipTypeRepository.findAll();
        if (allTypes.stream().anyMatch(m -> m.getId() == membershipType.getId())) {
            throw new EntityAllreadyExistsException(MembershipType.class.getSimpleName());
        }
        membershipTypeRepository.save(membershipType);
        return membershipType;
    }

    public MembershipType updateMembership(UUID id, MembershipType updatedMembershipType) throws EntityNotFoundException {
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

    public void deleteMembership(UUID id) throws EntityNotFoundException {
        membershipRepository.deleteMbTypeById(id);
    }
}
