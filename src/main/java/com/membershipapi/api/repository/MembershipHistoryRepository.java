package com.membershipapi.api.repository;

import com.membershipapi.api.model.MembershipHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipHistoryRepository extends JpaRepository<MembershipHistory, Long> {
    List<MembershipHistory> findByProfileId(int profileId);

    List<MembershipHistory> getMembershipHistoriesList();
}
