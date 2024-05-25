package com.membershipapi.api.service;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.repository.MembershipHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipHistoryService {

    @Autowired(required = true)
    private MembershipHistoryRepository repository;
//    private MembershipHistoryRepository repository = null;

    public List<MembershipHistory> getAllMembershipHistories() {
        return repository.findAll();
    }

    public Optional<MembershipHistory> getMembershipHistoryById(Long id) {
        return repository.findById(id);
    }

    public MembershipHistory createMembershipHistory(MembershipHistory membershipHistory) {
        return repository.save(membershipHistory);
    }

    public MembershipHistory updateMembershipHistory(Long id, MembershipHistory membershipHistory) {
        if (repository.existsById(id)) {
            membershipHistory.setId(id);
            return repository.save(membershipHistory);
        } else {
            return null;
        }
    }

    public void deleteMembershipHistory(Long id) {
        repository.deleteById(id);
    }
}
