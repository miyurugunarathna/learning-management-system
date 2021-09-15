package com.lms.api.controller;

import com.lms.api.model.Classes;
import com.lms.api.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClassesController {
    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private MongoOperations mongoOperations;

    // API to create a classes
    @PostMapping("/classes/add")
    public String saveClass(@RequestBody Classes classes){
        classesRepository.save(classes);
        return "Classes Successfully added";}

    // API to get classes by ID
    @GetMapping("/classes/{id}")
        public Optional<Classes> getClass(@PathVariable String id)
    {return classesRepository.findById(id);}

    // API to get all classes
    @GetMapping("/classes")
    public List<Classes> getClasses(){
        return classesRepository.findAll();
    }

    // API to delete a classes
    @DeleteMapping("/classes/delete/{id}")
    public String deleteClass(@PathVariable String id) {
        classesRepository.deleteById(id);
        return "The classes successfully deleted.";
    }
}
