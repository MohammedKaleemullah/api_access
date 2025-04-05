package com.kaleem.apiaccess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/api/payments")
    public String getPayments() {
        return "Payments data accessed !!";
    }
}
