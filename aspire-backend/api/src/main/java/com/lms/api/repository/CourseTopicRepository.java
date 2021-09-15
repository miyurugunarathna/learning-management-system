package com.lms.api.repository;

import com.lms.api.model.CourseTopic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTopicRepository extends MongoRepository<CourseTopic, String> {
}
