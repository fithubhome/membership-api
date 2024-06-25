package com.membershipapi.api.controller;

import com.membershipapi.api.model.external.PaymentModelDto;
import com.membershipapi.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/addpayment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping
    public void addPayment(@RequestBody PaymentModelDto paymentModelDto) {

        paymentService.savePaymentIntoMbHistoryPaymentRepo(paymentModelDto);

        //add Exception
    }

    @GetMapping("/{profileID}")
    public ResponseEntity<List<PaymentModelDto>> getMembershipHistoryByProfileId(@PathVariable UUID profileID) {
        List<PaymentModelDto> membershipHistory = paymentService.getMembershipHistoryByProfileId(profileID);

        return ResponseEntity.status(200).body(membershipHistory);
    }
}
