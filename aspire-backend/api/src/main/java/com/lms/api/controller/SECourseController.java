package com.lms.api.controller;



import com.lms.api.model.SECourse;
import com.lms.api.repository.SECourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SECourseController {

    @Autowired
    private SECourseRepository seCourseRepository;

    @Autowired
    private MongoOperations mongoOperations;

    // API to create a student enroll courses
    @PostMapping("/secourse/add")
    public String saveSECourse(@RequestBody SECourse seCourse){
        seCourseRepository.save(seCourse);
        return "student enroll courses Successfully added";}

    // API to get student enroll courses by ID
    @GetMapping("secourse/{id}")
    public Optional<SECourse> getSECourse(@PathVariable String id)
    {return seCourseRepository.findById(id);}

    // API to get all student enroll courses
    @GetMapping("/secourse")
    public List<SECourse> getSECourse(){
        return seCourseRepository.findAll();
    }

    // API to delete a Student enroll course
    @DeleteMapping("/secourse/delete/{id}")
    public String deleteSECourse(@PathVariable String id) {
        seCourseRepository.deleteById(id);
        return "The Student enroll course successfully deleted.";
    }
}
