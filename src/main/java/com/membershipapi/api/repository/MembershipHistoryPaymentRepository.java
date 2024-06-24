package com.membershipapi.api.repository;

import com.membershipapi.api.model.external.PaymentModelDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MembershipHistoryPaymentRepository extends JpaRepository <PaymentModelDto, UUID> {
}
