package com.lms.api.domain;

import java.util.List;

public interface ResultDataAdapter {
    Result Save(Result result);

    List<Result> getAll();

    Result update(Result result);

    void delete (String id);

    List<Result> getAllByStudentID(String studentID);

    List<Result> getAllByTeacherID(String teacherID);
}
