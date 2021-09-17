package com.lms.api.domain;

import java.util.List;

public interface ReplyDataAdapter {
    Reply Save(Reply reply);

    List<Reply> getAll();

    Reply update(Reply reply);

    void delete(String replyID);

    List<Reply> getAllByTeacherID(String tid);

    List<Reply> getAllByStudentID(String sid);
}
