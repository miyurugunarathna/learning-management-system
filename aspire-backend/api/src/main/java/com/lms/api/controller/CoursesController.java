package com.lms.api.controller;

import com.lms.api.model.Courses;
import com.lms.api.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CoursesController {

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private MongoOperations mongoOperations;

    // API to create a courses
    @PostMapping("/courses/add")
    public String saveCourse(@RequestBody Courses courses){
    coursesRepository.save(courses);
    return "Courses Successfully added";}


    // API to get courses by ID
    @GetMapping("/courses/{id}")
    public Optional<Courses> getCourse(@PathVariable String id) {
        return coursesRepository.findById(id);
    }

    // API to get all courses
    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return coursesRepository.findAll();
    }


    // API to delete a courses
    @DeleteMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable String id) {
        coursesRepository.deleteById(id);
        return "The courses successfully deleted.";
    }

    // API to update a courses
    @PostMapping("/courses/update/{id}")
    public String updateCourse(@RequestBody Courses courses, @PathVariable String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        System.out.println(query);
        Courses existCourses = mongoOperations.findOne(query, Courses.class);
        System.out.println(existCourses);
        if (existCourses != null) {
            existCourses.setClassID(courses.getClassID());
            existCourses.setSubjectID(courses.getSubjectID());
            existCourses.setTeacherID(courses.getTeacherID());
            existCourses.setDescription(courses.getDescription());
            mongoOperations.save(existCourses);
            return "The Courses successfully updated.";
        } else {
            return null;
        }
    }
}
