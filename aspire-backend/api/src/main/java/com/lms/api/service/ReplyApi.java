package com.lms.api.service;

import com.lms.api.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyApi {
    private final ReplyDataAdapter replyDataAdapter;

    @Autowired
    public ReplyApi(ReplyDataAdapter replyDataAdapter){
        this.replyDataAdapter = replyDataAdapter;
    }

    public List<Reply> getAllReply(){

        return replyDataAdapter.getAll();
    }

    public Reply addReply(Reply reply){
        reply = replyDataAdapter.Save(reply);

        return reply;
    }

    public Reply update(Reply reply) {
        return replyDataAdapter.update(reply);


    }
    public void delete(String qid){
        replyDataAdapter.delete(qid);
    }


    public List<Reply> getAllByStudentID(String sid){
        return replyDataAdapter.getAllByStudentID(sid);
    }

    public List<Reply> getAllByTeacherID(String tid){
        return replyDataAdapter.getAllByTeacherID(tid);
    }



}
