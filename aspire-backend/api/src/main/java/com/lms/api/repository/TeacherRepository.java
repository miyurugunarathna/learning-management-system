package com.lms.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lms.api.model.Teacher;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
	Teacher findByEmail(String email);
}