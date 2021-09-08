package com.lms.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.model.Student;
import com.lms.api.repository.StudentRepository;
import com.lms.api.exception.StudentNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StudentController {

	private final StudentRepository SRepo;

	StudentController (StudentRepository repository) {
		this.SRepo = repository;
	}

	// API to get all students
	@GetMapping("/students")
	public List<Student> list() {
		return SRepo.findAll();
	}

	// API to get student by ID
	@GetMapping("/student/{id}")
	public Student get(@PathVariable String id) {
		return SRepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(id));
	}

	// API to create a student
	@PostMapping("/addStudent")
	Student create(@RequestBody Student newStudent) {
		return SRepo.save(newStudent);
	}

	// API to update a student
	@PutMapping("/update/{id}")
	public Student update(@PathVariable String id, @RequestBody Student student) {
		return SRepo.findById(id)
				.map(s -> {
					s.setPid(student.getPid());
					s.setFname(student.getFname());
					s.setLname(student.getLname());
					s.setDob(student.getDob());
					s.setGender(student.getGender());
					s.setPhone(student.getPhone());
					s.setEmail(student.getEmail());
					s.setPassword(student.getPassword());
					return SRepo.save(s);
				})
				.orElseGet(() -> {
					student.setId(id);
					return SRepo.save(student);
				});
	}

	// API to delete a student
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		SRepo.deleteById(id);
	}
}