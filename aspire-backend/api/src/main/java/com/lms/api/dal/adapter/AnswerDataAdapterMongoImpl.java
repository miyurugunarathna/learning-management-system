package com.lms.api.dal.adapter;

import com.lms.api.dal.model.AnswerModel;
import com.lms.api.dal.repository.AnswerMongoRepository;
import com.lms.api.dal.repository.QuizMongoRepository;
import com.lms.api.domain.Answer;
import com.lms.api.domain.AnswerDataAdapter;
import com.lms.api.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerDataAdapterMongoImpl implements AnswerDataAdapter {
    private final AnswerMongoRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public AnswerDataAdapterMongoImpl(AnswerMongoRepository repository,MongoTemplate mongoTemplate){
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Answer Save(Answer answer) {
        AnswerModel answerModel = new AnswerModel();
        answerModel.setStudentID(answer.getStudentID());
        answerModel.setKey(answer.getKey());
        answerModel.setAnswer0(answer.getAnswer0());
        answerModel.setAnswer1(answer.getAnswer1());
        answerModel.setAnswer2(answer.getAnswer2());
        answerModel.setAnswer3(answer.getAnswer3());
        answerModel.setAnswer4(answer.getAnswer4());
        answerModel.setAnswer5(answer.getAnswer5());
        answerModel.setAnswer6(answer.getAnswer6());
        answerModel.setAnswer7(answer.getAnswer7());
        answerModel.setAnswer8(answer.getAnswer8());
        answerModel.setAnswer9(answer.getAnswer9());
        answerModel=repository.save(answerModel);
        answer.setTestID(answerModel.getTestID());
        return answer;
    }

    @Override
    public List<Answer> getAll() {
        List<AnswerModel> answerModels =repository.findAll();
        List<Answer> answers = new ArrayList<>();
        for (AnswerModel answerModel: answerModels){
            Answer answer =  new Answer();
            answer.setTestID(answerModel.getTestID());
            answer.setStudentID(answerModel.getStudentID());
            answer.setKey(answerModel.getKey());
            answer.setAnswer0(answerModel.getAnswer0());
            answer.setAnswer1(answerModel.getAnswer1());
            answer.setAnswer2(answerModel.getAnswer2());
            answer.setAnswer3(answerModel.getAnswer3());
            answer.setAnswer4(answerModel.getAnswer4());
            answer.setAnswer5(answerModel.getAnswer5());
            answer.setAnswer6(answerModel.getAnswer6());
            answer.setAnswer7(answerModel.getAnswer7());
            answer.setAnswer8(answerModel.getAnswer8());
            answer.setAnswer9(answerModel.getAnswer9());
            answers.add(answer);

        }
        return answers;
    }

    @Override
    public Answer update(Answer answer) {
        return null;
    }

    @Override
    public void delete(String testID) {
                repository.deleteAnswerModelByTestID(testID);
    }

    @Override
    public List<Answer> getAllByKey(String key) {
        List<AnswerModel> answerModels =repository.findAnswerModelByKey(key);
        List<Answer> answers = new ArrayList<>();

        for (AnswerModel answerModel: answerModels){
            Answer answer =  new Answer();
            answer.setTestID(answerModel.getTestID());
            answer.setStudentID(answerModel.getStudentID());
            answer.setKey(answerModel.getKey());
            answer.setAnswer0(answerModel.getAnswer0());
            answer.setAnswer1(answerModel.getAnswer1());
            answer.setAnswer2(answerModel.getAnswer2());
            answer.setAnswer3(answerModel.getAnswer3());
            answer.setAnswer4(answerModel.getAnswer4());
            answer.setAnswer5(answerModel.getAnswer5());
            answer.setAnswer6(answerModel.getAnswer6());
            answer.setAnswer7(answerModel.getAnswer7());
            answer.setAnswer8(answerModel.getAnswer8());
            answer.setAnswer9(answerModel.getAnswer9());
            answers.add(answer);

        }
        return answers;
    }
}
