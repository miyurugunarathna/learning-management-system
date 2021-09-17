package com.lms.api.dal.adapter;

import com.lms.api.dal.model.QuizModel;
import com.lms.api.dal.repository.QuizMongoRepository;
import com.lms.api.domain.Quiz;
import com.lms.api.domain.QuizDatAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizDataAdapterMongoImpl implements QuizDatAdapter {

    private final QuizMongoRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public QuizDataAdapterMongoImpl(QuizMongoRepository repository, MongoTemplate mongoTemplate){
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Quiz Save(Quiz quiz) {
        QuizModel quizModel = new QuizModel();
        quizModel.setQuestion(quiz.getQuestion());
        quizModel.setQnumber(quiz.getQnumber());
        quizModel.setOpt1(quiz.getOpt1());
        quizModel.setOpt2(quiz.getOpt2());
        quizModel.setOpt3(quiz.getOpt3());
        quizModel.setOpt4(quiz.getOpt4());
        quizModel.setAnswer(quiz.getAnswer());
        quizModel.setExamID(quiz.getExamID());
        quizModel.setTeacherID(quiz.getTeacherID());
        quizModel = repository.save(quizModel);
        quiz.setQid(quizModel.getQid());
        return  quiz;
    }

    @Override
    public List<Quiz> getAll() {
        List<QuizModel> quizModels = repository.findAll();
        List<Quiz> quizzes = new ArrayList<>();
        for(QuizModel quizModel: quizModels){
            Quiz quiz = new Quiz();
            quiz.setQid(quizModel.getQid());
            quiz.setQnumber(quizModel.getQnumber());
            quiz.setQuestion(quizModel.getQuestion());
            quiz.setOpt1(quizModel.getOpt1());
            quiz.setOpt2(quizModel.getOpt2());
            quiz.setOpt3(quizModel.getOpt3());
            quiz.setOpt4(quizModel.getOpt4());
            quiz.setAnswer(quizModel.getAnswer());
            quiz.setTeacherID(quizModel.getTeacherID());
            quiz.setExamID(quizModel.getExamID());
            quizzes.add(quiz);
        }
        return quizzes;
    }

    @Override
    public Quiz update(Quiz quiz) {
       QuizModel quizModel = mongoTemplate.findAndModify(Query.query(Criteria.where("qid").is(quiz.getQid())),
               new Update().set("question",quiz.getQuestion()).set("opt1",quiz.getOpt1()).set("opt2",quiz.getOpt2())
                       .set("opt3",quiz.getOpt3()).set("opt4",quiz.getOpt4()).set("answer",quiz.getAnswer()).set("teacherID",quiz.getTeacherID()).set("examID",quiz.getExamID()).set("qnumber",quiz.getQnumber()),
               QuizModel.class);
       return quiz;
    }

    @Override
    public void delete(String qid) {
        repository.deleteQuizModelByQid(qid);
    }

    @Override
    public List<Quiz> getAllByExamID(String examID) {
        List<QuizModel> quizModels = repository.findQuizModelByExamID(examID);
        List<Quiz> quizzes = new ArrayList<>();

        for(QuizModel quizModel: quizModels){
            Quiz quiz = new Quiz();
            quiz.setQid(quizModel.getQid());
            quiz.setQnumber(quizModel.getQnumber());
            quiz.setQuestion(quizModel.getQuestion());
            quiz.setOpt1(quizModel.getOpt1());
            quiz.setOpt2(quizModel.getOpt2());
            quiz.setOpt3(quizModel.getOpt3());
            quiz.setOpt4(quizModel.getOpt4());
            quiz.setAnswer(quizModel.getAnswer());
            quiz.setTeacherID(quizModel.getTeacherID());
            quiz.setExamID(quizModel.getExamID());
            quizzes.add(quiz);
        }

        return quizzes;
    }

    @Override
    public List<Quiz> getAllByTeacherID(String teacherID) {
        List<QuizModel> quizModels = repository.findQuizModelByTeacherID(teacherID);


        List<Quiz> quizzes = new ArrayList<>();

        for(QuizModel quizModel: quizModels){
            Quiz quiz = new Quiz();
            quiz.setQid(quizModel.getQid());
            quiz.setQnumber(quizModel.getQnumber());
            quiz.setQuestion(quizModel.getQuestion());
            quiz.setOpt1(quizModel.getOpt1());
            quiz.setOpt2(quizModel.getOpt2());
            quiz.setOpt3(quizModel.getOpt3());
            quiz.setOpt4(quizModel.getOpt4());
            quiz.setAnswer(quizModel.getAnswer());
            quiz.setTeacherID(quizModel.getTeacherID());
            quiz.setExamID(quizModel.getExamID());
            quizzes.add(quiz);
        }


        return quizzes;
    }

    @Override
    public List<Quiz> getAllByQnumber(String examID, int qnumber) {
        List<QuizModel> quizModels = repository.findQuizModelByExamIDAndQnumber(examID,qnumber);


        List<Quiz> quizzes = new ArrayList<>();

        for(QuizModel quizModel: quizModels){
            Quiz quiz = new Quiz();
            quiz.setQid(quizModel.getQid());
            quiz.setQnumber(quizModel.getQnumber());
            quiz.setQuestion(quizModel.getQuestion());
            quiz.setOpt1(quizModel.getOpt1());
            quiz.setOpt2(quizModel.getOpt2());
            quiz.setOpt3(quizModel.getOpt3());
            quiz.setOpt4(quizModel.getOpt4());
            quiz.setAnswer(quizModel.getAnswer());
            quiz.setTeacherID(quizModel.getTeacherID());
            quiz.setExamID(quizModel.getExamID());
            quizzes.add(quiz);
        }


        return quizzes;
    }


}
