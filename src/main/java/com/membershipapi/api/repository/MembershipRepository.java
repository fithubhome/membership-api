package com.membershipapi.api.repository;

import com.membershipapi.api.exception.EntityAllreadyExistsException;
import com.membershipapi.api.exception.EntityNotFoundException;
import com.membershipapi.api.model.MembershipType;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
public class MembershipRepository {

    private final List<MembershipType> membershipTypes = new ArrayList<>();

    public MembershipRepository() {
        membershipTypes.add(new MembershipType(1, "Gold", 500));
        membershipTypes.add(new MembershipType(2, "Silver", 200));
    }


    private int nextId = 1;

    public List<MembershipType> findAllMbTypes() {
        return membershipTypes;
    }

    public Optional<MembershipType> findMbTypeById(int id) throws EntityNotFoundException {

        Optional<MembershipType> mbType = membershipTypes.stream()
                .filter(membershipType -> membershipType.getId() == id)
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
        if (membershipType.getId() == 0) {
            membershipType.setId(nextId++);
            membershipTypes.add(membershipType);
        } else {
            membershipTypes.removeIf(m -> m.getId() == membershipType.getId());
            membershipTypes.add(membershipType);
        }
        return membershipType;
    }

    public void deleteMbTypeById(int id) throws EntityNotFoundException {
        boolean isRemoved = membershipTypes.removeIf(membershipType -> membershipType.getId() == id);

        if (!isRemoved) {
            throw new EntityNotFoundException(MembershipType.class.getSimpleName());
        }

    }
}
