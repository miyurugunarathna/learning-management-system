package com.lms.api.domain;

import java.util.List;

public interface NoticeDataAdapter {
    Notice Save(Notice notice);
    List<Notice> getAll();
    Notice update(Notice notice);
    void delete(String noticeID);
    List<Notice> getAllByNoticeID(String noticeID);
}
