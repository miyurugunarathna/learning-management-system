package com.lms.api.dto;

public class ResultDto {
    private String studentID;
    private String teacherID;
    private String term;
    private int assignmentMarks;
    private int quizMarks;
    private String status;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getAssignmentMarks() {
        return assignmentMarks;
    }

    public void setAssignmentMarks(int assignmentMarks) {
        this.assignmentMarks = assignmentMarks;
    }

    public int getQuizMarks() {
        return quizMarks;
    }

    public void setQuizMarks(int quizMarks) {
        this.quizMarks = quizMarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
}
