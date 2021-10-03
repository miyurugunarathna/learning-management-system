package com.lms.api.dal.adapter;

import com.lms.api.dal.model.AnswerModel;
import com.lms.api.dal.model.MarksModel;
import com.lms.api.dal.model.QuizModel;
import com.lms.api.dal.repository.AnswerMongoRepository;
import com.lms.api.dal.repository.MarksMongoRepository;
import com.lms.api.dal.repository.QuizMongoRepository;
import com.lms.api.domain.Answer;
import com.lms.api.domain.AnswerDataAdapter;
import com.lms.api.domain.Marks;
import com.lms.api.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerDataAdapterMongoImpl implements AnswerDataAdapter {
    private final AnswerMongoRepository repository;
    private final QuizMongoRepository repository2;
    private final MarksMongoRepository repository3;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public AnswerDataAdapterMongoImpl(AnswerMongoRepository repository,MongoTemplate mongoTemplate,QuizMongoRepository quizMongoRepository,MarksMongoRepository marksMongoRepository){
        this.repository = repository;
        this.repository2 = quizMongoRepository;
        this.repository3 = marksMongoRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Answer Save(Answer answer) {
        String[] ans = new String[10];
        int count = 0;
        int top=0;
        AnswerModel answerModel = new AnswerModel();
        Marks marks =new Marks();
        MarksModel marksModel = new MarksModel();
        answerModel.setStudentID(answer.getStudentID());
        answerModel.setKey(answer.getKey());
        List<QuizModel> quizModels = repository2.findQuizModelByExamID(answer.getKey());
        for(QuizModel quizModel: quizModels){

            ans[top]=quizModel.getAnswer();

            top=top+1;

        }
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

        if(ans[0].equals(answer.getAnswer0())){
            count=count+1;
        }
        if(ans[1].equals(answer.getAnswer1())){
            count=count+1;
        }
        if(ans[2].equals(answer.getAnswer2())){
            count=count+1;
        }
        if(ans[3].equals(answer.getAnswer3())){
            count=count+1;
        }
        if(ans[4].equals(answer.getAnswer4())){
            count=count+1;
        }
        if(ans[5].equals(answer.getAnswer5())){
            count=count+1;
        }
        if(ans[6].equals(answer.getAnswer6())){
            count=count+1;
        }
        if(ans[7].equals(answer.getAnswer7())){
            count=count+1;
        }
        if(ans[8].equals(answer.getAnswer8())){
            count=count+1;
        }
        if(ans[9].equals(answer.getAnswer9())){
            count=count+1;
        }

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
