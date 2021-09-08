package com.lms.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "free-card")

public class FreeCard {

private String description;
private String classID;
private String subjectID;
private String studentID;
private String teacherID;
private String startMonth;
private String expiryDate;
private String status;

    public FreeCard() {
    }

    public FreeCard(String description, String classID, String subjectID, String studentID, String teacherID, String startMonth, String expiryDate, String status) {
        this.description = description;
        this.classID = classID;
        this.subjectID = subjectID;
        this.studentID = studentID;
        this.teacherID = teacherID;
        this.startMonth = startMonth;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public String getClassID() {
        return classID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
