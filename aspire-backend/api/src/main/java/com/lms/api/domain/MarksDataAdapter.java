package com.lms.api.domain;

import java.util.List;

public interface MarksDataAdapter {

    List<Marks> Save(String key );
    List<Marks> getAllByStudentID(String studentid);
}
