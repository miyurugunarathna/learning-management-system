package com.lms.api.controller;

import com.lms.api.model.Fee;
import com.lms.api.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FeeController {
    @Autowired
    private FeeRepository feeRepository;
    @Autowired
    private MongoOperations mongoOperations;

    @PostMapping("/fees/add")
    public String saveFee(@RequestBody Fee fee) {
        feeRepository.save(fee);
        return "Fees successfully added.";
    }

    @GetMapping("/fees")
    public List<Fee> getFees() {
        return feeRepository.findAll();
    }

    @GetMapping("/fees/{id}")
    public Optional<Fee> getFee(@PathVariable String id) {
        return feeRepository.findById(id);
    }

    @DeleteMapping("/fees/delete/{id}")
    public String deleteFee(@PathVariable String id) {
        feeRepository.deleteById(id);
        return "The fee successfully deleted.";
    }

    @PostMapping("/fees/update/{id}")
    public String updateFee(@RequestBody Fee fee, @PathVariable String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        System.out.println(query);
        Fee existFee = mongoOperations.findOne(query, Fee.class);
        System.out.println(existFee);
        if (existFee != null) {
            existFee.setFeeName(fee.getFeeName());
            existFee.setFeeType(fee.getFeeType());
            existFee.setAmount(fee.getAmount());
            existFee.setFrequency(fee.getFrequency());
            mongoOperations.save(existFee);
            return "The fee successfully updated.";
        } else {
            return null;
        }
    }
}
