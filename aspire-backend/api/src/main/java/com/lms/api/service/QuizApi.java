package com.lms.api.service;

import com.lms.api.domain.Quiz;
import com.lms.api.domain.QuizDatAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizApi {


    private final QuizDatAdapter quizDatAdapter;

    @Autowired
    public QuizApi(QuizDatAdapter quizDatAdapter) {

        this.quizDatAdapter = quizDatAdapter;

    }

    public List<Quiz> getAllQuizes(){

        return quizDatAdapter.getAll();
    }

    public Quiz addQuiz(Quiz quiz){
        quiz = quizDatAdapter.Save(quiz);

        return quiz;
    }

    public Quiz update(Quiz quiz) {
        return quizDatAdapter.update(quiz);


    }
    public void delete(String qid){
        quizDatAdapter.delete(qid);
    }

    public List<Quiz> getAllByExamID(String examID){
        return quizDatAdapter.getAllByExamID(examID);
    }

    public List<Quiz> getAllByTeacherID(String teacherID){
        return quizDatAdapter.getAllByTeacherID(teacherID);
    }

    public List<Quiz> getAllByQnumber(String examID, int qnumber){
        return quizDatAdapter.getAllByQnumber(examID,qnumber);
    }
}
