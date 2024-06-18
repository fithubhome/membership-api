package com.membershipapi.api.repository;


import com.membershipapi.api.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType, UUID> {
}
