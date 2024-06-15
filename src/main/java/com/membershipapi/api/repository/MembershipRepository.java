package com.membershipapi.api.repository;

import com.membershipapi.api.exception.EntityAllreadyExistsException;
import com.membershipapi.api.exception.EntityNotFoundException;
import com.membershipapi.api.model.MembershipType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Getter
public class MembershipRepository {

    @Autowired
    private MembershipTypeRepository membershipTypeRepository;
    private final List<MembershipType> membershipTypes = new ArrayList<>();

//    private int nextId = 1;

    public List<MembershipType> findAllMbTypes() {
        return membershipTypes;
    }

    public Optional<MembershipType> findMbTypeById(UUID id) throws EntityNotFoundException {

        Optional<MembershipType> mbType = membershipTypes.stream()
                .filter(membershipType -> membershipType.getId().equals(id))
                .findFirst();
        if (mbType.isEmpty()) {
            throw new EntityNotFoundException(MembershipType.class.getSimpleName());
        }
        return mbType;
    }


    public MembershipType createMembership(MembershipType membershipType) throws EntityAllreadyExistsException {
        if (membershipTypes.stream().anyMatch(m -> m.getId() == membershipType.getId())) {
            throw new EntityAllreadyExistsException(MembershipType.class.getSimpleName());
        }
        membershipTypes.add(membershipType);
        return membershipType;
    }

    public MembershipType updateMbType(MembershipType membershipType) {

            membershipTypes.removeIf(m -> m.getId() == membershipType.getId());
            membershipTypes.add(membershipType);

        return membershipType;
    }


}
