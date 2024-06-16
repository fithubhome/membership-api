package com.membershipapi.api.service;

import com.membershipapi.api.exception.EntityAllreadyExistsException;
import com.membershipapi.api.exception.EntityNotFoundException;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.repository.MembershipTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class MembershipTypeService {

    private final MembershipTypeRepository membershipTypeRepository;

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

        if (!membershipTypeRepository.existsById(id)) {
            throw new EntityNotFoundException(MembershipType.class.getSimpleName());
        }

        membershipTypeRepository.deleteById(id);
        membershipTypeRepository.save(updatedMembershipType);
        return updatedMembershipType;
    }

    public void deleteMembership(UUID id) throws EntityNotFoundException {
        if (membershipTypeRepository.existsById(id)) {
            membershipTypeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(MembershipType.class.getSimpleName());
        }
    }
}
