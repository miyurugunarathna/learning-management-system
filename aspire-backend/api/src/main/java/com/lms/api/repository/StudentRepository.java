package com.lms.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lms.api.model.Student;
//import com.lms.api.model.User;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
	
	Student findByEmail(String email);
	
}