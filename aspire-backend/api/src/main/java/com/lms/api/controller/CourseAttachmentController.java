package com.lms.api.controller;


import com.lms.api.model.CourseAttachment;
import com.lms.api.repository.CourseAttachmentRepository;
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
public class CourseAttachmentController {
    @Autowired
    private CourseAttachmentRepository courseAttachmentRepository;

    @Autowired
    private MongoOperations mongoOperations;

    // API to create a courseattachment
    @PostMapping("/courseattachment/add")
    public String saveCourseAttachment(@RequestBody CourseAttachment courseAttachment){
        courseAttachmentRepository.save(courseAttachment);
        return "Course Attachment Successfully added";}

    // API to get  courseattachment by ID
    @GetMapping("/courseattachment/{id}")
    public Optional<CourseAttachment> getCourseAttachment(@PathVariable String id)
    {return courseAttachmentRepository.findById(id);}

    // API to get all courseattachment
    @GetMapping("/courseattachment")
    public List<CourseAttachment> getCourseAttachment(){
        return courseAttachmentRepository.findAll();
    }

    // API to delete a courseattachment
    @DeleteMapping("/courseattachment/delete/{id}")
    public String deleteCourseAttachment(@PathVariable String id) {
        courseAttachmentRepository.deleteById(id);
        return "The Course Attachment successfully deleted.";
    }

    // API to update a courseattachment
    @PostMapping("/courseattachment/update/{id}")
    public String updateCourseAttachment(@RequestBody CourseAttachment courseAttachment, @PathVariable String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        System.out.println(query);
        CourseAttachment existCourseAttachment = mongoOperations.findOne(query, CourseAttachment.class);
        System.out.println(existCourseAttachment);
        if (existCourseAttachment != null) {
            existCourseAttachment.setClassID(courseAttachment.getClassID());
            existCourseAttachment.setSubjectID(courseAttachment.getSubjectID());
            existCourseAttachment.setTeacherID(courseAttachment.getTeacherID());
            existCourseAttachment.setTitle(courseAttachment.getTitle());
            existCourseAttachment.setUrl(courseAttachment.getUrl());
            mongoOperations.save(existCourseAttachment);
            return "The Course Attachment successfully updated.";
        } else {
            return null;
        }
    }


}
