package com.lms.api.service;

import com.lms.api.model.Badge;
import com.lms.api.repository.BadgeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BadgeService {

//    @Autowired
//    private MongoTemplate mongoTemplate;

    private final BadgeRepository BRepo;

    public BadgeService(BadgeRepository BRepo) {
        this.BRepo = BRepo;
    }

    public Badge save(Badge badge) {
        return BRepo.save(badge);
    }

    public Optional<Badge> get(String id) {
        return BRepo.findById(id);
    }

    public List<Badge> list() {
        return BRepo.findAll();

//        LookupOperation lookupOperation = LookupOperation.newLookup().
//                from("subject").
//                localField("subjectID").
//                foreignField("_id").
//                as("SName");
//        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
//        AggregationResults<Badge> results = mongoTemplate.aggregate(aggregation, "badge", Badge.class);
//        return results.getMappedResults();

    }

    public ResponseEntity<Map<String, Boolean>> delete(String id) {
        BRepo.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put(id, Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public Badge updateBadge(Badge badge) {
        return BRepo.save(badge);
    }



}