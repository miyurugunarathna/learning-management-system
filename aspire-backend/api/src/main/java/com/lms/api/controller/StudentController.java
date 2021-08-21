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
import com.lms.api.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// API to get student by ID
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> get(@PathVariable String id) {
		return studentService.get(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound()
						.build());
	}

	// API to get all students
	@GetMapping("/students")
	public List<Student> list() {
		return studentService.list();
	}

	// API to create a student
	@PostMapping("/addstudent")
	public String save(@RequestBody Student student) {
		return studentService.save(student)
				.getId();
	}

	// API to delete a student
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable String id) {
		return studentService.delete(id);
	}
}