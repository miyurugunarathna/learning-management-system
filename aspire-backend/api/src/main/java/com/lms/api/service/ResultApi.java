package com.lms.api.service;

import com.lms.api.domain.Quiz;
import com.lms.api.domain.Result;
import com.lms.api.domain.ResultDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultApi {

    private final ResultDataAdapter resultDataAdapter;

    @Autowired
    public ResultApi(ResultDataAdapter resultDataAdapter){
        this.resultDataAdapter = resultDataAdapter;

    }

    public List<Result> getAllResult(){
        return resultDataAdapter.getAll();
    }

    public Result addResult(Result result){

        result = resultDataAdapter.Save(result);
        return result;
    }

    public Result update (Result result){
        return resultDataAdapter.update(result);
    }
    public void delete(String id){
        resultDataAdapter.delete(id);
    }

    public List<Result> getAllByStudentID(String studentID){
        return resultDataAdapter.getAllByStudentID(studentID);
    }

    public List<Result> getAllByTeacherID(String teacherID){
        return resultDataAdapter.getAllByTeacherID(teacherID);
    }


}
