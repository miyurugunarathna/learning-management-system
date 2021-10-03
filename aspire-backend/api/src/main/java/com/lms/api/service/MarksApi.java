package com.lms.api.service;

import com.lms.api.domain.Marks;
import com.lms.api.domain.MarksDataAdapter;
import com.lms.api.domain.Quiz;
import com.lms.api.domain.QuizDatAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksApi {

    private final MarksDataAdapter marksDataAdapter;

    @Autowired
    public MarksApi(MarksDataAdapter marksDataAdapter){
        this.marksDataAdapter = marksDataAdapter;
    }

    public List<Marks> addMarks(String key ){
        return marksDataAdapter.Save(key);
    }

    public List<Marks> getMarksbystudentid(String studentid){
        return marksDataAdapter.getAllByStudentID(studentid);
    }


}
