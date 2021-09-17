package com.lms.api.dal.adapter;

import com.lms.api.dal.model.ExamModel;
import com.lms.api.dal.model.QuestionModel;
import com.lms.api.dal.model.QuizModel;
import com.lms.api.dal.repository.QuestionMongoRepository;
import com.lms.api.dal.repository.QuizMongoRepository;
import com.lms.api.domain.Question;
import com.lms.api.domain.QuestionDataAdapter;
import com.lms.api.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionDataAdapterMongoImpl implements QuestionDataAdapter {

    private final QuestionMongoRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public QuestionDataAdapterMongoImpl(QuestionMongoRepository questionMongoRepository , MongoTemplate mongoTemplate){
        this.repository = questionMongoRepository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Question Save(Question question) {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setDate(question.getDate());
        questionModel.setDescription(question.getDescription());
        questionModel.setTid(question.getTid());
        questionModel.setSid(question.getSid());
        questionModel.setClassID(question.getClassID());
        questionModel.setSubjectID(question.getSubjectID());
        questionModel.setTitle(question.getTitle());
        questionModel = repository.save(questionModel);
        question.setQid(questionModel.getQid());
        return question;
    }

    @Override
    public List<Question> getAll() {
        List<QuestionModel> questionModels = repository.findAll();
        List<Question> questions = new ArrayList<>();
        for(QuestionModel questionModel: questionModels){
            Question question = new Question();
            question.setQid(questionModel.getQid());
            question.setDate(questionModel.getDate());
            question.setDescription(questionModel.getDescription());
            question.setTid(questionModel.getTid());
            question.setSid(questionModel.getSid());
            question.setClassID(questionModel.getClassID());
            question.setSubjectID(questionModel.getSubjectID());
            question.setTitle(questionModel.getTitle());
            questions.add(question);

        }
        return questions;
    }

    @Override
    public Question update(Question question) {
        QuestionModel questionModel = mongoTemplate.findAndModify(Query.query(Criteria.where("qid").is(question.getQid())),
                new Update().set("sid", question.getSid()).set("tid",question.getTid())
                        .set("title", question.getTitle()).set("description", question.getDescription()).set("classID",question.getClassID()).set("subjectID",question.getSubjectID()).set("date",question.getDate()),QuestionModel.class);

        return question;
    }

    @Override
    public void delete(String qid) {
        repository.deleteQuestionModelByQid(qid);
    }

    @Override
    public List<Question> getAllByTeacherID(String tid) {
        List<QuestionModel> questionModels = repository.findQuestionModelByTid(tid);
        List<Question> questions = new ArrayList<>();
        for(QuestionModel questionModel: questionModels){
            Question question = new Question();
            question.setQid(questionModel.getQid());
            question.setDate(questionModel.getDate());
            question.setDescription(questionModel.getDescription());
            question.setTid(questionModel.getTid());
            question.setSid(questionModel.getSid());
            question.setClassID(questionModel.getClassID());
            question.setSubjectID(questionModel.getSubjectID());
            question.setTitle(questionModel.getTitle());
            questions.add(question);

        }
        return questions;
    }

    @Override
    public List<Question> getAllByStudentID(String sid) {
        List<QuestionModel> questionModels = repository.findQuestionModelBySid(sid);
        List<Question> questions = new ArrayList<>();
        for(QuestionModel questionModel: questionModels){
            Question question = new Question();
            question.setQid(questionModel.getQid());
            question.setDate(questionModel.getDate());
            question.setDescription(questionModel.getDescription());
            question.setTid(questionModel.getTid());
            question.setSid(questionModel.getSid());
            question.setClassID(questionModel.getClassID());
            question.setSubjectID(questionModel.getSubjectID());
            question.setTitle(questionModel.getTitle());
            questions.add(question);

        }
        return questions;
    }
}
