package com.lms.api.repository;

import com.lms.api.model.Classes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends MongoRepository<Classes, String> {
}