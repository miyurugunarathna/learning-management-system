package com.lms.api.dal.repository;

import com.lms.api.dal.model.ExamModel;
import com.lms.api.dal.model.MarksModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksMongoRepository extends MongoRepository<MarksModel,String> {
    List<MarksModel> findMarksModelBySid(String studentid);
}
