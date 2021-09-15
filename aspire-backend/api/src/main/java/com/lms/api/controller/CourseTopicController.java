package com.lms.api.controller;

import com.lms.api.model.CourseTopic;
import com.lms.api.repository.CourseTopicRepository;
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
public class CourseTopicController {
    @Autowired
    private CourseTopicRepository courseTopicRepository;

    @Autowired
    private MongoOperations mongoOperations;

    // API to create a coursetopic
    @PostMapping("/coursetopic/add")
    public String saveCourseTopic(@RequestBody CourseTopic courseTopic){
        courseTopicRepository.save(courseTopic);
        return "CourseTopic Successfully added";}

    // API to get  coursetopic by ID
    @GetMapping("/coursetopic/{id}")
    public Optional<CourseTopic> getCourseTopic(@PathVariable String id)
    {return courseTopicRepository.findById(id);}

    // API to get all coursetopic
    @GetMapping("/coursetopic")
    public List<CourseTopic> getCourseTopics(){
        return courseTopicRepository.findAll();
    }

    // API to delete a coursetopic
    @DeleteMapping("/coursetopic/delete/{id}")
    public String deleteCourseTopic(@PathVariable String id) {
        courseTopicRepository.deleteById(id);
        return "The coursetopic successfully deleted.";
    }

    // API to update a coursetopic
    @PostMapping("/coursetopic/update/{id}")
    public String updateCourseTopic(@RequestBody CourseTopic courseTopic, @PathVariable String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        System.out.println(query);
        CourseTopic existCourseTopic = mongoOperations.findOne(query, CourseTopic.class);
        System.out.println(existCourseTopic);
        if (existCourseTopic != null) {
            existCourseTopic.setClassID(courseTopic.getClassID());
            existCourseTopic.setSubjectID(courseTopic.getSubjectID());
            existCourseTopic.setTeacherID(courseTopic.getTeacherID());
            existCourseTopic.setTitle(courseTopic.getTitle());
            existCourseTopic.setDescription(courseTopic.getDescription());
            mongoOperations.save(existCourseTopic);
            return "The Courses successfully updated.";
        } else {
            return null;
        }
    }
}
