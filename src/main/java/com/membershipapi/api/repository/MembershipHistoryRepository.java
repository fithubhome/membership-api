package com.membershipapi.api.repository;

import com.membershipapi.api.model.MembershipHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MembershipHistoryRepository extends JpaRepository<MembershipHistory, UUID> {

    List<MembershipHistory> findByProfileId(UUID profileId);
}
