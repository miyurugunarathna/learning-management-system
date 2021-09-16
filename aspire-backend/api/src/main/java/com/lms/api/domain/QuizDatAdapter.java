package com.lms.api.domain;

import java.util.List;

public interface QuizDatAdapter {
    Quiz Save(Quiz quiz);

    List<Quiz> getAll();

    Quiz update(Quiz quiz);

    void delete(String qid);

    List<Quiz> getAllByExamID(String examID);

    List<Quiz> getAllByTeacherID(String teacherID);

    List<Quiz> getAllByQnumber(String examID,int qnumber);

}
