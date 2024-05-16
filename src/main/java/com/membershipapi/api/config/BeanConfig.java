package com.membershipapi.api.config;

import com.membershipapi.api.exception.EntityNotFoundException;
import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.repository.MembershipHistoryRepository;
import com.membershipapi.api.repository.MembershipRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BeanConfig {

    // De verrificat cu Mihai de ce nu merge metoda asta; Practic membershipHistoryRepository() se initializaeaza inainte de membershipRepository() - as cred cu debugger
//    @Bean
//    public MembershipRepository membershipRepository() {
//        MembershipRepository membershipRepository = new MembershipRepository();
//        populateMembershipRepositoryList(membershipRepository);
//
//        return membershipRepository;
//    }
//
//    private void populateMembershipRepositoryList(MembershipRepository membershipRepository){
//
//        List<MembershipType> membershipRepositoryList = membershipRepository.getMembershipTypes();
//        membershipRepositoryList.add(new MembershipType(1, "Gold", 500));
//        membershipRepositoryList.add(new MembershipType(2, "Silver", 200));
//    }

    @Bean
    public MembershipHistoryRepository membershipHistoryRepository() throws EntityNotFoundException {
        MembershipHistoryRepository membershipHistoryRepository = new MembershipHistoryRepository();
        MembershipRepository membershipRepository = new MembershipRepository();

        populateMembershipHistoriesList(membershipHistoryRepository, membershipRepository);

        return membershipHistoryRepository;
    }

    private void populateMembershipHistoriesList(MembershipHistoryRepository membershipHistoryRepository, MembershipRepository membershipRepository) throws EntityNotFoundException {
        List<MembershipHistory> membershipHistoriesList = membershipHistoryRepository.getMembershipHistoriesList();
        MembershipType membershipTypeError = new MembershipType(0, "Membership type error", 0); //this "error" is captured here as we do not have a logger yet

        membershipHistoriesList.add(new MembershipHistory(1, 1, membershipRepository.findMbTypeById(1).orElseGet(() -> membershipTypeError).getName(), LocalDate.now(), LocalDate.now().plusDays(60), membershipRepository.findMbTypeById(1).orElseGet(() -> membershipTypeError).getPrice()));
        membershipHistoriesList.add(new MembershipHistory(1, 1, membershipRepository.findMbTypeById(2).orElseGet(() -> membershipTypeError).getName(), LocalDate.now(), LocalDate.now().plusDays(30), membershipRepository.findMbTypeById(2).orElseGet(() -> membershipTypeError).getPrice()));
    }


}
