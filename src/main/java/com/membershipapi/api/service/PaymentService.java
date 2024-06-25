package com.membershipapi.api.service;

import com.membershipapi.api.model.external.PaymentModelDto;
import com.membershipapi.api.repository.MembershipHistoryPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    MembershipHistoryPaymentRepository membershipHistoryPaymentRepository;

    public void savePaymentIntoMbHistoryPaymentRepo(PaymentModelDto paymentModelDto) {
        membershipHistoryPaymentRepository.save(paymentModelDto);
    }

    public List<PaymentModelDto> getMembershipHistoryByProfileId (UUID profileID) {
       return membershipHistoryPaymentRepository.findByProfileID(profileID);
    }


}
