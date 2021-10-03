package com.lms.api.dal.repository;

import com.lms.api.dal.model.AnswerModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerMongoRepository extends MongoRepository<AnswerModel,String> {
    void deleteAnswerModelByTestID(String testID);
    List<AnswerModel>findAnswerModelByKey(String key);
    List<AnswerModel>findAnswerModelByStudentID(String studentid);
}
