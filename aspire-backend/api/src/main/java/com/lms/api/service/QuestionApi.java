package com.lms.api.service;

import com.lms.api.domain.ExamDataAdapter;
import com.lms.api.domain.Question;
import com.lms.api.domain.QuestionDataAdapter;
import com.lms.api.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionApi {
    private final QuestionDataAdapter questionDataAdapter;

    @Autowired
    public QuestionApi(QuestionDataAdapter questionDataAdapter){
        this.questionDataAdapter = questionDataAdapter;
    }


    public List<Question> getAllQuestions(){

        return questionDataAdapter.getAll();
    }

    public Question addQuestion(Question question){
        question = questionDataAdapter.Save(question);

        return question;
    }

    public Question update(Question question) {
        return questionDataAdapter.update(question);


    }
    public void delete(String qid){
        questionDataAdapter.delete(qid);
    }

    public List<Question> getAllByStudentID(String sid){
        return questionDataAdapter.getAllByStudentID(sid);
    }

    public List<Question> getAllByTeacherID(String tid){
        return questionDataAdapter.getAllByTeacherID(tid);
    }


}
