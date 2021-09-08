package com.lms.api.controller;

import com.lms.api.model.Payment;
import com.lms.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/payments/add")
    public String savePayment(@RequestBody Payment payment) {
        paymentRepository.save(payment);
        return "Added payment with id: " + payment.getPaymentID();
    }

    @GetMapping("/payments")
    public List<Payment> getPayments() {
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("fee").
                localField("feeID").
                foreignField("_id").
                as("fees");
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        AggregationResults<Payment> results = mongoTemplate.aggregate(aggregation, "payment", Payment.class);
        return results.getMappedResults();
    }
}
