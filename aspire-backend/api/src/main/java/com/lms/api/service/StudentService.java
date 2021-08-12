package com.lms.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lms.api.model.Student;
import com.lms.api.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository SRepo;
	
	public StudentService(StudentRepository SRepo) {
		this.SRepo = SRepo;
	}
	
	public Student save(Student student) {
		return SRepo.save(student);
	}
	
	public Optional<Student> get(String id) {
		return SRepo.findById(id);
	}
	
	public List<Student> list() {
		return SRepo.findAll();
	}
}
