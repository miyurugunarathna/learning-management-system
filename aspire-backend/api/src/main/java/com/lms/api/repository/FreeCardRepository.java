package com.lms.api.repository;


import com.lms.api.model.FreeCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeCardRepository extends MongoRepository<FreeCard, String> {
}
