package com.lms.api.repository;

import com.lms.api.model.Courses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends MongoRepository<Courses, String> {

}
