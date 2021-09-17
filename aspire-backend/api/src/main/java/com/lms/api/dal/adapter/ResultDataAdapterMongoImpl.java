package com.lms.api.dal.adapter;

import com.lms.api.dal.model.ResultModel;
import com.lms.api.dal.repository.ResultMongoRepository;
import com.lms.api.domain.Result;
import com.lms.api.domain.ResultDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultDataAdapterMongoImpl implements ResultDataAdapter {

    private final ResultMongoRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ResultDataAdapterMongoImpl(ResultMongoRepository repository , MongoTemplate mongoTemplate){
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Result Save(Result result) {
        ResultModel resultModel = new ResultModel();
        resultModel.setStudentID(result.getStudentID());
        resultModel.setTeacherID(result.getTeacherID());
        resultModel.setTerm(result.getTerm());
        resultModel.setAssignmentMarks(result.getAssignmentMarks());
        resultModel.setQuizMarks(result.getQuizMarks());
        resultModel.setStatus(result.getStatus());
        resultModel = repository.save(resultModel);
        result.setId(resultModel.getId());


        return result;
    }

    @Override
    public List<Result> getAll() {
        List<ResultModel> resultModels = repository.findAll();

        List<Result> results2 = new ArrayList<>();

        for (ResultModel resultModel: resultModels){
            Result result = new Result();
            result.setId(resultModel.getId());
            result.setTeacherID(resultModel.getTeacherID());
            result.setStudentID(resultModel.getStudentID());
            result.setTerm(resultModel.getTerm());
            result.setQuizMarks(resultModel.getQuizMarks());
            result.setStatus(resultModel.getStatus());
            result.setAssignmentMarks(resultModel.getAssignmentMarks());
            results2.add(result);
        }
        return results2;
    }



    @Override
    public Result update(Result result) {

        ResultModel resultModel = mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(result.getId())),
                new Update().set("teacherID",result.getTeacherID()).set("studentID",result.getStudentID()).set("term",result.getTerm()).set("assignmentMarks",result.getAssignmentMarks())
                        .set("quizMarks",result.getQuizMarks()).set("status",result.getStatus()),ResultModel.class);

        return result;
    }

    @Override
    public void delete(String id) {
    repository.deleteResultModelById(id);
    }

    @Override
    public List<Result> getAllByStudentID(String studentID) {
        List<ResultModel> resultModels = repository.findResultModelByStudentID(studentID);

        List<Result> results3 = new ArrayList<>();

        for (ResultModel resultModel: resultModels){
            Result result = new Result();
            result.setId(resultModel.getId());
            result.setTeacherID(resultModel.getTeacherID());
            result.setStudentID(resultModel.getStudentID());
            result.setTerm(resultModel.getTerm());
            result.setQuizMarks(resultModel.getQuizMarks());
            result.setStatus(resultModel.getStatus());
            result.setAssignmentMarks(resultModel.getAssignmentMarks());
            results3.add(result);
        }
        return results3;
    }

    @Override
    public List<Result> getAllByTeacherID(String teacherID) {
        List<ResultModel> resultModels = repository.findResultModelByTeacherID(teacherID);

        List<Result> results4 = new ArrayList<>();

        for (ResultModel resultModel: resultModels){
            Result result = new Result();
            result.setId(resultModel.getId());
            result.setTeacherID(resultModel.getTeacherID());
            result.setStudentID(resultModel.getStudentID());
            result.setTerm(resultModel.getTerm());
            result.setQuizMarks(resultModel.getQuizMarks());
            result.setStatus(resultModel.getStatus());
            result.setAssignmentMarks(resultModel.getAssignmentMarks());
            results4.add(result);
        }
        return results4;
    }
}
