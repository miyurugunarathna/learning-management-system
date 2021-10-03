package com.lms.api.domain;
import java.util.List;

public interface StudentEnrollmentTestDataAdapter {
    StudentEnrollmentTest Save(StudentEnrollmentTest studentEnrollmentTest);
    List<StudentEnrollmentTest>getAllByTeacherID(String teacherID);

    List<StudentEnrollmentTest>getAllByStudentID(String studentID);
}
