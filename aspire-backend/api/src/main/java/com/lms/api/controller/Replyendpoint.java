package com.lms.api.controller;

import com.lms.api.service.QuestionApi;
import com.lms.api.service.ReplyApi;
import com.lms.api.domain.Question;
import com.lms.api.domain.Reply;
import com.lms.api.dto.QuestionsDto;
import com.lms.api.dto.ReplyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/replies")
public class Replyendpoint {


    private ReplyApi replyApi;

    @Autowired
    public Replyendpoint(ReplyApi replyApi){
        this.replyApi = replyApi;
    }

    @GetMapping
    public List<Reply> getReplies(){
        return replyApi.getAllReply();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reply addReply(@RequestBody ReplyDto replyDto){
        Reply reply = new Reply();
        reply.setSid(replyDto.getSid());
        reply.setTid(replyDto.getTid());
        reply.setQid(replyDto.getQid());
        reply.setDate(replyDto.getDate());
        reply.setDescription(replyDto.getDescription());

        return replyApi.addReply(reply);

    }

    @PutMapping("/{replyID}")
    @ResponseStatus(HttpStatus.CREATED)
    public Reply updateReplies(@PathVariable String replyID , @RequestBody ReplyDto replyDto){
        Reply reply = new Reply();
        reply.setReplyID(replyID);
        reply.setSid(replyDto.getSid());
        reply.setTid(replyDto.getTid());
        reply.setQid(replyDto.getQid());
        reply.setDate(replyDto.getDate());
        reply.setDescription(replyDto.getDescription());


        return replyApi.update(reply);

    }

    @DeleteMapping("/{replyID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String replyID ){
        replyApi.delete(replyID);

    }

    @GetMapping("/reply1/{sid}")
    public List<Reply> getAllByStudentID(@PathVariable String sid){
        return replyApi.getAllByStudentID(sid);
    }


    @GetMapping("/reply2/{tid}")
    public List<Reply> getAllByTeacherID(@PathVariable String tid){
        return replyApi.getAllByTeacherID(tid);
    }



}
