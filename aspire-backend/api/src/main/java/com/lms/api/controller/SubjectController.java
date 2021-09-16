package com.lms.api.controller;


import com.lms.api.model.Subject;
import com.lms.api.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private MongoOperations mongoOperations;

    // API to create a subject
    @PostMapping("/subject/add")
    public String saveSubject(@RequestBody Subject subject){
        subjectRepository.save(subject);
        return "Subject Successfully added";}

    // API to get subject by ID
    @GetMapping("/subject/{id}")
    public Optional<Subject> getSubject(@PathVariable String id)
    {return subjectRepository.findById(id);}

    // API to get all subject
    @GetMapping("/subject")
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    // API to delete a subject
    @DeleteMapping("/subject/delete/{id}")
    public String deleteSubject(@PathVariable String id) {
        subjectRepository.deleteById(id);
        return "The subject successfully deleted.";
    }

}
