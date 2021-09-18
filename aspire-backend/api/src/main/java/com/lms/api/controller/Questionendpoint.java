package com.lms.api.controller;


import com.lms.api.service.QuestionApi;
import com.lms.api.service.QuizApi;
import com.lms.api.domain.Question;
import com.lms.api.domain.Quiz;
import com.lms.api.dto.QuestionsDto;
import com.lms.api.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/questions")
public class Questionendpoint {


    private QuestionApi questionApi;

    @Autowired
    public Questionendpoint(QuestionApi questionApi){
        this.questionApi = questionApi;
    }

    @GetMapping
    public List<Question> getQuestions(){
        return questionApi.getAllQuestions();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question addQuestion(@RequestBody QuestionsDto questionsDto){
       Question question = new Question();
        question.setSid(questionsDto.getSid());
        question.setTitle(questionsDto.getTitle());
        question.setDate(questionsDto.getDate());
        question.setTid(questionsDto.getTid());
        question.setDescription(questionsDto.getDescription());
        question.setSubjectID(questionsDto.getSubjectID());
        question.setClassID(questionsDto.getClassID());
        return questionApi.addQuestion(question);

    }

    @PutMapping("/{qid}")
    @ResponseStatus(HttpStatus.CREATED)
    public Question updateQuestion(@PathVariable String qid , @RequestBody QuestionsDto questionsDto){
       Question question = new Question();
        question.setQid(qid);
        question.setSid(questionsDto.getSid());
        question.setTitle(questionsDto.getTitle());
        question.setDate(questionsDto.getDate());
        question.setTid(questionsDto.getTid());
        question.setDescription(questionsDto.getDescription());
        question.setSubjectID(questionsDto.getSubjectID());
        question.setClassID(questionsDto.getClassID());

        return questionApi.update(question);

    }

    @DeleteMapping("/{qid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String qid ){
        questionApi.delete(qid);

    }

    @GetMapping("/student/{sid}")
    public List<Question> getAllByStudentID(@PathVariable String sid){
        return questionApi.getAllByStudentID(sid);
    }


    @GetMapping("/teacher/{tid}")
    public List<Question> getAllByTeacherID(@PathVariable String tid){
        return questionApi.getAllByTeacherID(tid);
    }



}
