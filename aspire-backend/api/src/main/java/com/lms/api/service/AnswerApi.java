package com.lms.api.service;

import com.lms.api.domain.Answer;
import com.lms.api.domain.AnswerDataAdapter;
import com.lms.api.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerApi {
    private final AnswerDataAdapter answerDataAdapter;

    @Autowired
    public AnswerApi(AnswerDataAdapter answerDataAdapter){
        this.answerDataAdapter = answerDataAdapter;

    }

    public List<Answer> getAllAnswer(){

        return answerDataAdapter.getAll();
    }

    public Answer addAnswer(Answer answer){
        answer = answerDataAdapter.Save(answer);

        return answer;
    }


    public void delete(String testID){
        answerDataAdapter.delete(testID);
    }

    public List<Answer> getAllByKey(String key){
        return answerDataAdapter.getAllByKey(key);
    }



}
