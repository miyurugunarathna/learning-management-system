package com.lms.api.controller;

import com.lms.api.model.Payment;
import com.lms.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/payments/add")
    public String savePayment(@RequestBody Payment payment) {
        paymentRepository.save(payment);
        return String.valueOf(payment.getPaymentID());
    }

    @GetMapping("/payments")
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/payments/{id}")
    public Optional<Payment> getFee(@PathVariable String id) {
        return paymentRepository.findById(id);
    }
}
