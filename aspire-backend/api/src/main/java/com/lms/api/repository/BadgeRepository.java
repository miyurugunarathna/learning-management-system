package com.lms.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lms.api.model.Badge;

@Repository
public interface BadgeRepository extends MongoRepository<Badge, String> {

}