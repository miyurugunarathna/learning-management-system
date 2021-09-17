package com.lms.api.service;

import com.lms.api.domain.Notice;
import com.lms.api.domain.NoticeDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeApi {
    private final NoticeDataAdapter noticeDataAdapter;

    @Autowired
    public NoticeApi(NoticeDataAdapter noticeDataAdapter){
        this.noticeDataAdapter = noticeDataAdapter;

    }
    public List<Notice> getAllNotices(){
        return noticeDataAdapter.getAll();
    }

    public Notice addNotice(Notice notice){
        notice = noticeDataAdapter.Save(notice);
        return notice;
    }

    public Notice update(Notice notice){
        return noticeDataAdapter.update(notice);
    }

    public void delete(String noticeID){
        noticeDataAdapter.delete(noticeID);
    }
}
