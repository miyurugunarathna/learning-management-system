package com.lms.api.dal.adapter;

import com.lms.api.dal.model.AnswerModel;
import com.lms.api.dal.model.ExamModel;
import com.lms.api.dal.model.MarksModel;
import com.lms.api.dal.model.QuizModel;
import com.lms.api.dal.repository.AnswerMongoRepository;
import com.lms.api.dal.repository.MarksMongoRepository;
import com.lms.api.dal.repository.QuizMongoRepository;
import com.lms.api.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarksDataAdapterMongoImpl implements MarksDataAdapter {

    private final AnswerMongoRepository repository1;
    private final QuizMongoRepository repository;
    private final MarksMongoRepository repository2;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MarksDataAdapterMongoImpl(AnswerMongoRepository answerMongoRepository,QuizMongoRepository quizMongoRepository,MongoTemplate mongoTemplate,MarksMongoRepository marksMongoRepository){
        this.repository1 = answerMongoRepository;
        this.repository = quizMongoRepository;
        this.mongoTemplate = mongoTemplate;
        this.repository2 = marksMongoRepository;
    }
    @Override
    public List<Marks> Save(String key ) {
        List<QuizModel> quizModels = repository.findQuizModelByExamID(key);
        List<AnswerModel> answerModels =repository1.findAnswerModelByKey(key);
        List<Marks> marks2 = new ArrayList<>();

        String[] ans = new String[10];
        int count = 0;
        int top=0;
        for(QuizModel quizModel: quizModels){

            ans[top]=quizModel.getAnswer();

            top=top+1;

        }
        for (AnswerModel answerModel: answerModels){
            MarksModel marksModel = new MarksModel();
            Marks marks =new Marks();

            if(ans[0].equals(answerModel.getAnswer0())){
                count=count+1;
            }
            if(ans[1].equals(answerModel.getAnswer1())){
                count=count+1;
            }
            if(ans[2].equals(answerModel.getAnswer2())){
                count=count+1;
            }
            if(ans[3].equals(answerModel.getAnswer3())){
                count=count+1;
            }
            if(ans[4].equals(answerModel.getAnswer4())){
                count=count+1;
            }
            if(ans[5].equals(answerModel.getAnswer5())){
                count=count+1;
            }
            if(ans[6].equals(answerModel.getAnswer6())){
                count=count+1;
            }
            if(ans[7].equals(answerModel.getAnswer7())){
                count=count+1;
            }
            if(ans[8].equals(answerModel.getAnswer8())){
                count=count+1;
            }
            if(ans[9].equals(answerModel.getAnswer9())){
                count=count+1;
            }

            marksModel.setSid(answerModel.getStudentID());
            marksModel.setKey(answerModel.getKey());
            marksModel.setQ_marks(count);
            repository2.save(marksModel);
            marks.setMid(marksModel.getMid());

            marks.setSid(marksModel.getSid());
            marks.setKey(marksModel.getKey());
            marks.setQ_marks(marksModel.getQ_marks());
            marks2.add(marks);

            count = 0;


        }




        return marks2;
    }

    @Override
    public List<Marks> getAllByStudentID(String studentid) {
        List<MarksModel> marksModels = repository2.findMarksModelBySid(studentid);
        List<Marks> marks = new ArrayList<>();

        for(MarksModel marksModel: marksModels){
            Marks marks1 = new Marks();
            marks1.setKey(marksModel.getKey());
            marks1.setMid(marksModel.getMid());
            marks1.setQ_marks(marksModel.getQ_marks());
            marks1.setSid(marksModel.getSid());


            marks.add(marks1);
        }
        return marks;
    }

}
