package com.membershipapi.api.repository;

import com.membershipapi.api.model.MembershipType;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MembershipRepository {

    private final List<MembershipType> membershipTypes = new ArrayList<>();
    private int nextId = 1;

    public List<MembershipType> findAll() {
        return membershipTypes;
    }

    public Optional<MembershipType> findById(int id) {
        return membershipTypes.stream()
                .filter(membershipType -> membershipType.getId() == id)
                .findFirst();
    }

    public MembershipType save(MembershipType membershipType) {
        if (membershipType.getId() == 0) {
            membershipType.setId(nextId++);
            membershipTypes.add(membershipType);
        } else {
            membershipTypes.removeIf(m -> m.getId() == membershipType.getId());
            membershipTypes.add(membershipType);
        }
        return membershipType;
    }

    public void deleteById(int id) {
        membershipTypes.removeIf(membershipType -> membershipType.getId() == id);
    }
}
