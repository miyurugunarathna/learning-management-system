package com.lms.api.dal.repository;

import com.lms.api.dal.model.StudentEnrollmentTestModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentEnrollmentTestMongoRepository extends MongoRepository<StudentEnrollmentTestModel,String> {

    List<StudentEnrollmentTestModel>findStudentEnrollmentTestModelByTeacherID(String teacherID);

    List<StudentEnrollmentTestModel> findStudentEnrollmentTestModelByStudentID(String studentID);
}
