package com.lms.api.controller;

import com.lms.api.service.AnswerApi;
import com.lms.api.domain.Answer;
import com.lms.api.domain.Quiz;
import com.lms.api.dto.AnswerDto;
import com.lms.api.dto.QuizDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/answers")
public class Answerendpoint {

    private AnswerApi answerApi;

    @Autowired
    public Answerendpoint(AnswerApi answerApi){
        this.answerApi=answerApi;
    }

    @GetMapping
    public List<Answer> getAllAnswers(){
        return answerApi.getAllAnswer();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Answer addAnswer(@RequestBody AnswerDto answerDto){
        Answer answer= new Answer();
        answer.setStudentID(answerDto.getStudentID());
        answer.setKey(answerDto.getKey());
        answer.setAnswer0(answerDto.getAnswer0());
        answer.setAnswer1(answerDto.getAnswer1());
        answer.setAnswer2(answerDto.getAnswer2());
        answer.setAnswer3(answerDto.getAnswer3());
        answer.setAnswer4(answerDto.getAnswer4());
        answer.setAnswer5(answerDto.getAnswer5());
        answer.setAnswer6(answerDto.getAnswer6());
        answer.setAnswer7(answerDto.getAnswer7());
        answer.setAnswer8(answerDto.getAnswer8());
        answer.setAnswer9(answerDto.getAnswer9());
        return answerApi.addAnswer(answer);

    }



    @DeleteMapping("/{testID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String testID ){
        answerApi.delete(testID);

    }

    @GetMapping("/answer/{key}")
    public List<Answer> getAllByKey(@PathVariable String key){
        return answerApi.getAllByKey(key);
    }
}
