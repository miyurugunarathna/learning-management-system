package com.lms.api.controller;

import com.lms.api.service.MarksApi;
import com.lms.api.service.QuizApi;
import com.lms.api.domain.Marks;
import com.lms.api.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/marks")
public class Marksendpoint {

    private MarksApi marksApi;

    @Autowired
    public Marksendpoint(MarksApi marksApi){
        this.marksApi = marksApi;
    }


    @GetMapping("/{key}")
    public List<Marks> addMarks(@PathVariable String key ){
        return marksApi.addMarks(key);
    }

    @GetMapping("/student/{sid}")
    public List<Marks> getMarksBystudentid(@PathVariable String sid){
        return marksApi.getMarksbystudentid(sid);
    }

}
