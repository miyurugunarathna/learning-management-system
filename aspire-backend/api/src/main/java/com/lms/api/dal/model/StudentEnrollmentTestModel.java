package com.lms.api.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("enroll")
public class StudentEnrollmentTestModel {

    @Id
    private String enrollID;
    private String classID;
    private String subjectID;
    private String teacherID;
    private String studentID;


    public String getEnrollID() {
        return enrollID;
    }

    public void setEnrollID(String enrollID) {
        this.enrollID = enrollID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
