package com.lms.api.domain;

import java.util.List;

public interface AnswerDataAdapter {

    Answer Save(Answer answer);

    List<Answer> getAll();

    Answer update(Answer answer);

    void delete(String testID);

    List<Answer> getAllByKey(String key);





}
