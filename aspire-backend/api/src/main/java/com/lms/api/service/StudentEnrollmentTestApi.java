package com.lms.api.service;

import com.lms.api.domain.StudentEnrollmentTest;
import com.lms.api.domain.StudentEnrollmentTestDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentEnrollmentTestApi {

    private final StudentEnrollmentTestDataAdapter studentEnrollmentTestDataAdapter;

    @Autowired
    public StudentEnrollmentTestApi(StudentEnrollmentTestDataAdapter studentEnrollmentTestDataAdapter){
        this.studentEnrollmentTestDataAdapter = studentEnrollmentTestDataAdapter;
    }

    public StudentEnrollmentTest addStudentEnrollmentTest(StudentEnrollmentTest studentEnrollmentTest){
        studentEnrollmentTest = studentEnrollmentTestDataAdapter.Save(studentEnrollmentTest);
        return studentEnrollmentTest;
    }

    public List<StudentEnrollmentTest> getAllByTeacherID(String teacherID){
        return studentEnrollmentTestDataAdapter.getAllByTeacherID(teacherID);
    }

    public List<StudentEnrollmentTest> getAllByStudentID(String studentID){
        return studentEnrollmentTestDataAdapter.getAllByStudentID(studentID);
    }
}
