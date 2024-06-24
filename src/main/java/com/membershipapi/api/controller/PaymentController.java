package com.membershipapi.api.controller;

import com.membershipapi.api.model.external.PaymentModelDto;
import com.membershipapi.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addpayment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping
    public void addPayment(@RequestBody PaymentModelDto paymentModelDto) {

            paymentService.savePaymentIntoMbHistoryPaymentRepo(paymentModelDto);

        //add trhow Error
    }

}
