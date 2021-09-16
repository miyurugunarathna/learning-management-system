package com.lms.api.dal.repository;

import com.lms.api.dal.model.ExamModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMongoRepository extends MongoRepository<ExamModel,String> {
    void deleteExamModelByExamID(String examID);
    List<ExamModel>findExamModelByTeacherID(String teacherID);
}
