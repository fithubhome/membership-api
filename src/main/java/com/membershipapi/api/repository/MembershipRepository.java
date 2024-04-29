package com.membershipapi.api.repository;

import com.membershipapi.api.model.Membership;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MembershipRepository {

    private final List<Membership> memberships = new ArrayList<>();
    private int nextId = 1;

    public List<Membership> findAll() {
        return memberships;
    }

    public Optional<Membership> findById(int id) {
        return memberships.stream()
                .filter(membership -> membership.getId() == id)
                .findFirst();
    }

    public Membership save(Membership membership) {
        if (membership.getId() == 0) {
            membership.setId(nextId++);
            memberships.add(membership);
        } else {
            memberships.removeIf(m -> m.getId() == membership.getId());
            memberships.add(membership);
        }
        return membership;
    }

    public void deleteById(int id) {
        memberships.removeIf(membership -> membership.getId() == id);
    }
}
