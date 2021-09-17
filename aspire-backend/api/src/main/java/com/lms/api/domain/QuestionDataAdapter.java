package com.lms.api.domain;

import java.util.List;

public interface QuestionDataAdapter {

    Question Save(Question question);

    List<Question> getAll();

    Question update(Question question);

    void delete(String qid);

    List<Question> getAllByTeacherID(String tid);

    List<Question> getAllByStudentID(String sid);



}
