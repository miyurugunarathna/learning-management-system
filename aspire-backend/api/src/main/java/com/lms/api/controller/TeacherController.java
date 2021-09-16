package com.lms.api.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.exception.TeacherNotFoundException;
import com.lms.api.model.Teacher;
import com.lms.api.repository.StudentRepository;
import com.lms.api.repository.TeacherRepository;
//import com.lms.api.exception.TeacherNotFoundException;
import com.lms.api.security.jwt.JwtTokenProvider;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	private final TeacherRepository TRepo;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	TeacherRepository teachers;


	TeacherController (TeacherRepository repository) {
		this.TRepo = repository;
	}

	// API to get all teachers
	@GetMapping("/all")
	public List<Teacher> listTeachers() {
		return TRepo.findAll();
	}

	// API to get teacher by ID
	@GetMapping("/get/{id}")
	public Teacher getTeacher(@PathVariable String id) {
		return TRepo.findById(id)
				.orElseThrow(() -> new TeacherNotFoundException(id));
	}

	// API to create a teacher
	@PostMapping("/add")
	Teacher createTeacher(@RequestBody Teacher newTeacher) {
		newTeacher.setRole("Teacher");
		newTeacher.setApproved("Pending");
		newTeacher.setActive(true);
		return TRepo.save(newTeacher);
	}

	// API to update a teacher
	@PutMapping("/update/{id}")
	public Teacher updateTeacher(@PathVariable String id, @RequestBody Teacher teacher) {
		return TRepo.findById(id)
				.map(t -> {
					t.setPid(teacher.getPid());
					t.setFname(teacher.getFname());
					t.setLname(teacher.getLname());
					t.setDob(teacher.getDob());
					t.setGender(teacher.getGender());
					t.setPhone(teacher.getPhone());
					t.setEmail(teacher.getEmail());
					t.setPassword(teacher.getPassword());
					t.setTitle(teacher.getTitle());
					t.setDescription(teacher.getDescription());
					t.setUniversity(teacher.getUniversity());
					t.setBank(teacher.getBank());
					t.setBranch(teacher.getBranch());
					t.setAccnum(teacher.getAccnum());
					t.setApproved(teacher.getApproved());
					t.setActive(teacher.getActive());
					t.setRole(teacher.getRole());
					return TRepo.save(t);
				})
				.orElseGet(() -> {
					teacher.setId(id);
					return TRepo.save(teacher);
				});
	}

	// API to delete a teacher
	@DeleteMapping("/delete/{id}")
	public void deleteTeacher(@PathVariable String id) {
		TRepo.deleteById(id);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthBody data) {
		try {
			String username = data.getEmail();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
			String token = jwtTokenProvider.createToken(username, this.teachers.findByEmail(username).getRoles());
			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("token", token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid email/password supplied");
		}
	}
}