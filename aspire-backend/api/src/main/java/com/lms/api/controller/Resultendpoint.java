package com.lms.api.controller;

import com.lms.api.service.ResultApi;
import com.lms.api.domain.Result;
import com.lms.api.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/results")
public class Resultendpoint {

    private ResultApi resultApi;

    @Autowired
    public Resultendpoint(ResultApi resultApi){
        this.resultApi = resultApi;
    }

    @GetMapping
    public List<Result>getResults(){
        return resultApi.getAllResult();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result addResult(@RequestBody ResultDto resultDto){
        Result result = new Result();
        result.setTeacherID(resultDto.getTeacherID());
        result.setStudentID(resultDto.getStudentID());
        result.setStatus(resultDto.getStatus());
        result.setTerm(resultDto.getTerm());
        result.setQuizMarks(resultDto.getQuizMarks());
        result.setAssignmentMarks(resultDto.getAssignmentMarks());
        return resultApi.addResult(result);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Result updateResult(@PathVariable String id , @RequestBody ResultDto resultDto){
        Result result = new Result();
        result.setId(id);
        result.setTeacherID(resultDto.getTeacherID());
        result.setStudentID(resultDto.getStudentID());
        result.setStatus(resultDto.getStatus());
        result.setTerm(resultDto.getTerm());
        result.setQuizMarks(resultDto.getQuizMarks());
        result.setAssignmentMarks(resultDto.getAssignmentMarks());
        return resultApi.update(result);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        resultApi.delete(id);
    }


     @GetMapping("/student/{studentID}")
     public List<Result> getAllByStudentID(@PathVariable String studentID){
        return resultApi.getAllByStudentID(studentID);
    }

    @GetMapping("/teacher/{teacherID}")
    public List<Result> getAllByTeacherID(@PathVariable String teacherID){
        return resultApi.getAllByTeacherID(teacherID);

    }



}
