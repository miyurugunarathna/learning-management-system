package com.lms.api.controller;

import com.lms.api.service.StudentEnrollmentTestApi;
import com.lms.api.domain.StudentEnrollmentTest;
import com.lms.api.dto.StudentEnrollmentTestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enroll")
public class StudentEnrollmentTestendpoint {

    private StudentEnrollmentTestApi studentEnrollmentTestApi;

    @Autowired
    public StudentEnrollmentTestendpoint(StudentEnrollmentTestApi studentEnrollmentTestApi){
         this.studentEnrollmentTestApi = studentEnrollmentTestApi;
     }

     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public StudentEnrollmentTest addStudentEnrollmentTest(@RequestBody StudentEnrollmentTestDto studentEnrollmentTestDto){
        StudentEnrollmentTest studentEnrollmentTest = new StudentEnrollmentTest();
        studentEnrollmentTest.setStudentID(studentEnrollmentTestDto.getStudentID());
        studentEnrollmentTest.setTeacherID(studentEnrollmentTestDto.getTeacherID());
        studentEnrollmentTest.setSubjectID(studentEnrollmentTestDto.getSubjectID());
        studentEnrollmentTest.setClassID(studentEnrollmentTestDto.getClassID());
        return studentEnrollmentTestApi.addStudentEnrollmentTest(studentEnrollmentTest);

     }

    @GetMapping("/teacher/{teacherID}")
    public List<StudentEnrollmentTest> getAllByTeacherID(@PathVariable String teacherID){

        return studentEnrollmentTestApi.getAllByTeacherID(teacherID);
    }

    @GetMapping("/student/{studentID}")
    public List<StudentEnrollmentTest> getAllByStudentID(@PathVariable String studentID){

        return studentEnrollmentTestApi.getAllByStudentID(studentID);
    }
}
