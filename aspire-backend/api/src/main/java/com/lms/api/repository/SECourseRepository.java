package com.lms.api.repository;

import com.lms.api.model.SECourse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SECourseRepository extends MongoRepository<SECourse, String> {
}
