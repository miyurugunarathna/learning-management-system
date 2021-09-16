package com.lms.api.service;

import com.lms.api.domain.Exam;
import com.lms.api.domain.ExamDataAdapter;
import com.lms.api.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ExamApi {

    private final ExamDataAdapter examDataAdapter;

    @Autowired
    public ExamApi(ExamDataAdapter examDataAdapter){

        this.examDataAdapter = examDataAdapter;
    }

    public Exam addExam(Exam exam){


        String id = generateIDs((ArrayList<String>) examDataAdapter.getAll());
        exam.setExamID(id);
        exam = examDataAdapter.Save(exam);
        return exam;

    }

    public static String generateIDs(ArrayList<String> arrayList) {

        String id;
        int next = arrayList.size();
        next++;
        id = "E0" + next;
        if (arrayList.contains(id)) {
            next++;
            id = "E0" + next;
        }
        return id;
    }



    public List<Exam> getAllByTeacherID(String teacherID){
        return examDataAdapter.getAllByTeacherID(teacherID);
    }
    public void delete(String examID){
        examDataAdapter.delete(examID);
    }

    public Exam update(Exam exam) {
        return examDataAdapter.update(exam);


    }
}
