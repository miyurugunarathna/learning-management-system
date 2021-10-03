package com.lms.api.dal.adapter;

import com.lms.api.dal.model.StudentEnrollmentTestModel;
import com.lms.api.dal.repository.StudentEnrollmentTestMongoRepository;
import com.lms.api.domain.StudentEnrollmentTest;
import com.lms.api.domain.StudentEnrollmentTestDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentEnrollmentTestDataAdapterMongoImpl implements StudentEnrollmentTestDataAdapter {

    private final StudentEnrollmentTestMongoRepository repository;

    @Autowired
    public StudentEnrollmentTestDataAdapterMongoImpl(StudentEnrollmentTestMongoRepository repository){
        this.repository = repository;
    }
    @Override
    public StudentEnrollmentTest Save(StudentEnrollmentTest studentEnrollmentTest) {
        StudentEnrollmentTestModel studentEnrollmentTestModel= new StudentEnrollmentTestModel();
        studentEnrollmentTestModel.setClassID(studentEnrollmentTest.getClassID());
        studentEnrollmentTestModel.setSubjectID(studentEnrollmentTest.getSubjectID());
        studentEnrollmentTestModel.setStudentID(studentEnrollmentTest.getStudentID());
        studentEnrollmentTestModel.setTeacherID(studentEnrollmentTest.getTeacherID());
        studentEnrollmentTestModel = repository.save(studentEnrollmentTestModel);
        studentEnrollmentTest.setEnrollID(studentEnrollmentTestModel.getEnrollID());
        return studentEnrollmentTest;
    }

    @Override
    public List<StudentEnrollmentTest> getAllByTeacherID(String teacherID) {
        List<StudentEnrollmentTestModel> studentEnrollmentTestModels = repository.findStudentEnrollmentTestModelByTeacherID(teacherID);
        List<StudentEnrollmentTest> studentEnrollmentTests = new ArrayList<>();

        for(StudentEnrollmentTestModel studentEnrollmentTestModel: studentEnrollmentTestModels){
            StudentEnrollmentTest studentEnrollmentTest = new StudentEnrollmentTest();
            studentEnrollmentTest.setStudentID(studentEnrollmentTestModel.getStudentID());
            studentEnrollmentTest.setTeacherID(studentEnrollmentTestModel.getTeacherID());
            studentEnrollmentTest.setClassID(studentEnrollmentTestModel.getClassID());
            studentEnrollmentTest.setSubjectID(studentEnrollmentTestModel.getSubjectID());
            studentEnrollmentTest.setEnrollID(studentEnrollmentTestModel.getEnrollID());
            studentEnrollmentTests.add(studentEnrollmentTest);
        }
        return studentEnrollmentTests;
    }




    @Override
    public List<StudentEnrollmentTest> getAllByStudentID(String studentID) {

        List<StudentEnrollmentTestModel> studentEnrollmentTestModels = repository.findStudentEnrollmentTestModelByStudentID(studentID);
        List<StudentEnrollmentTest> studentEnrollmentTests = new ArrayList<>();

        for(StudentEnrollmentTestModel studentEnrollmentTestModel: studentEnrollmentTestModels){
            StudentEnrollmentTest studentEnrollmentTest = new StudentEnrollmentTest();
            studentEnrollmentTest.setStudentID(studentEnrollmentTestModel.getStudentID());
            studentEnrollmentTest.setTeacherID(studentEnrollmentTestModel.getTeacherID());
            studentEnrollmentTest.setClassID(studentEnrollmentTestModel.getClassID());
            studentEnrollmentTest.setSubjectID(studentEnrollmentTestModel.getSubjectID());
            studentEnrollmentTest.setEnrollID(studentEnrollmentTestModel.getEnrollID());
            studentEnrollmentTests.add(studentEnrollmentTest);
        }
        return studentEnrollmentTests;
    }
}
