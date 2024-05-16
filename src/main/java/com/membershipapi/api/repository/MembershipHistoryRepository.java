package com.membershipapi.api.repository;

import com.membershipapi.api.model.MembershipHistory;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class MembershipHistoryRepository {
    private final List<MembershipHistory> membershipHistoriesList = new ArrayList<>();

}
