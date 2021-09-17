package com.lms.api.controller;

import com.lms.api.service.ExamApi;
import com.lms.api.domain.Exam;
import com.lms.api.domain.Quiz;
import com.lms.api.dto.ExamDto;
import com.lms.api.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/exams")
public class Examendpoint {

    private ExamApi examApi;

    @Autowired
    public Examendpoint(ExamApi examApi){
        this.examApi = examApi;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exam addExam(@RequestBody ExamDto examDto){
        Exam exam = new Exam();
        exam.setExamName(examDto.getExamName());
        exam.setTeacherID(examDto.getTeacherID());
        exam.setClassID(examDto.getClassID());
        exam.setSubjectID(examDto.getSubjectID());
        return examApi.addExam(exam);

    }

    @GetMapping("/{teacherID}")
    public List<Exam> getAllByTeacherID(@PathVariable String teacherID){
        return examApi.getAllByTeacherID(teacherID);
    }

    @DeleteMapping("/{examID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String examID){
        examApi.delete(examID);

    }


    @PutMapping("/{key}")
    @ResponseStatus(HttpStatus.CREATED)
    public Exam updateExam(@PathVariable String key , @RequestBody ExamDto examDto){


        Exam exam = new Exam();
        exam.setKey(key);
        exam.setExamName(examDto.getExamName());

        exam.setTeacherID(examDto.getTeacherID());
        exam.setClassID(examDto.getClassID());
        exam.setSubjectID(examDto.getSubjectID());
        return examApi.update(exam);


    }

}
