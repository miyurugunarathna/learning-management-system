package com.lms.api.dal.repository;

import com.lms.api.dal.model.QuestionModel;
import com.lms.api.dal.model.QuizModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMongoRepository extends MongoRepository<QuestionModel,String> {

    void deleteQuestionModelByQid(String qid);
    List<QuestionModel> findQuestionModelByTid(String tid);
    List<QuestionModel>findQuestionModelBySid(String sid);

}
