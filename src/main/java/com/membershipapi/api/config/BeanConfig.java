package com.membershipapi.api.config;

import com.membershipapi.api.model.MembershipHistory;
import com.membershipapi.api.repository.MembershipHistoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

//package com.membershipapi.api.config;
//
//import com.membershipapi.api.exception.EntityNotFoundException;
//import com.membershipapi.api.model.MembershipHistory;
//import com.membershipapi.api.model.MembershipType;
//import com.membershipapi.api.repository.MembershipHistoryRepository;
//import com.membershipapi.api.repository.MembershipRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.context.annotation.Scope;
//
//import java.time.LocalDate;
//import java.util.List;
//
@Configuration
@EnableJpaRepositories(basePackages = "com.membershipapi.api.repository")
public class BeanConfig {

//    @Bean
//    public MembershipHistoryRepository membershipHistoryRepository(){
//        return new MembershipHistoryRepository() {
//            @Override
//            public void flush() {
//
//            }
//
//            @Override
//            public <S extends MembershipHistory> S saveAndFlush(S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends MembershipHistory> List<S> saveAllAndFlush(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public void deleteAllInBatch(Iterable<MembershipHistory> entities) {
//
//            }
//
//            @Override
//            public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAllInBatch() {
//
//            }
//
//            @Override
//            public MembershipHistory getOne(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public MembershipHistory getById(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public MembershipHistory getReferenceById(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public <S extends MembershipHistory> List<S> findAll(Example<S> example) {
//                return null;
//            }
//
//            @Override
//            public <S extends MembershipHistory> List<S> findAll(Example<S> example, Sort sort) {
//                return null;
//            }
//
//            @Override
//            public <S extends MembershipHistory> List<S> saveAll(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public List<MembershipHistory> findAll() {
//                return null;
//            }
//
//            @Override
//            public List<MembershipHistory> findAllById(Iterable<Long> longs) {
//                return null;
//            }
//
//            @Override
//            public <S extends MembershipHistory> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public Optional<MembershipHistory> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(MembershipHistory entity) {
//
//            }
//
//            @Override
//            public void deleteAllById(Iterable<? extends Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends MembershipHistory> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//
//            @Override
//            public List<MembershipHistory> findAll(Sort sort) {
//                return null;
//            }
//
//            @Override
//            public Page<MembershipHistory> findAll(Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends MembershipHistory> Optional<S> findOne(Example<S> example) {
//                return Optional.empty();
//            }
//
//            @Override
//            public <S extends MembershipHistory> Page<S> findAll(Example<S> example, Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends MembershipHistory> long count(Example<S> example) {
//                return 0;
//            }
//
//            @Override
//            public <S extends MembershipHistory> boolean exists(Example<S> example) {
//                return false;
//            }
//
//            @Override
//            public <S extends MembershipHistory, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//                return null;
//            }
//        };
//    }
//
//    // De verrificat cu Mihai de ce nu merge metoda asta; Practic membershipHistoryRepository() se initializaeaza inainte de membershipRepository() - as cred cu debugger
////    @Bean
////    public MembershipRepository membershipRepository() {
////        MembershipRepository membershipRepository = new MembershipRepository();
////        populateMembershipRepositoryList(membershipRepository);
////
////        return membershipRepository;
////    }
////
////    private void populateMembershipRepositoryList(MembershipRepository membershipRepository){
////
////        List<MembershipType> membershipRepositoryList = membershipRepository.getMembershipTypes();
////        membershipRepositoryList.add(new MembershipType(1, "Gold", 500));
////        membershipRepositoryList.add(new MembershipType(2, "Silver", 200));
////    }
//
//    @Bean
////    public MembershipHistoryRepository membershipHistoryRepository() throws EntityNotFoundException {
////        MembershipHistoryRepository membershipHistoryRepository = new MembershipHistoryRepository();
////        MembershipRepository membershipRepository = new MembershipRepository();
////
////        populateMembershipHistoriesList(membershipHistoryRepository, membershipRepository);
////
////        return membershipHistoryRepository;
////    }
//
////    private void populateMembershipHistoriesList(MembershipHistoryRepository membershipHistoryRepository, MembershipRepository membershipRepository) throws EntityNotFoundException {
////        List<MembershipHistory> membershipHistoriesList = membershipHistoryRepository.getMembershipHistoriesList();
////        MembershipType membershipTypeError = new MembershipType(0, "Membership type error", 0); //this "error" is captured here as we do not have a logger yet
////
////        membershipHistoriesList.add(new MembershipHistory(1, 1, membershipRepository.findMbTypeById(1).orElseGet(() -> membershipTypeError).getName(), LocalDate.now(), LocalDate.now().plusDays(60), membershipRepository.findMbTypeById(1).orElseGet(() -> membershipTypeError).getPrice()));
////        membershipHistoriesList.add(new MembershipHistory(1, 1, membershipRepository.findMbTypeById(2).orElseGet(() -> membershipTypeError).getName(), LocalDate.now(), LocalDate.now().plusDays(30), membershipRepository.findMbTypeById(2).orElseGet(() -> membershipTypeError).getPrice()));
////    }
}
