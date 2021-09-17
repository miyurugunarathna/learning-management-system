package com.lms.api.dal.adapter;

import com.lms.api.dal.model.ExamModel;
import com.lms.api.dal.model.QuestionModel;
import com.lms.api.dal.model.ReplyModel;
import com.lms.api.dal.repository.QuestionMongoRepository;
import com.lms.api.dal.repository.ReplyMongRepository;
import com.lms.api.domain.Question;
import com.lms.api.domain.Reply;
import com.lms.api.domain.ReplyDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReplyDataAdapterMongoImpl implements ReplyDataAdapter {

    private final ReplyMongRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReplyDataAdapterMongoImpl(ReplyMongRepository replyMongRepository,MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
        this.repository = replyMongRepository;
    }

    @Override
    public Reply Save(Reply reply) {
        ReplyModel replyModel = new ReplyModel();
        replyModel.setDate(reply.getDate());
        replyModel.setTid(reply.getTid());
        replyModel.setSid(reply.getSid());
        replyModel.setQid(reply.getQid());
        replyModel.setDescription(reply.getDescription());
        replyModel = repository.save(replyModel);
        reply.setReplyID(replyModel.getReplyID());

        return reply;
    }

    @Override
    public List<Reply> getAll() {
        List<ReplyModel> replyModels = repository.findAll();
        List<Reply> replies = new ArrayList<>();
        for(ReplyModel replyModel: replyModels){
            Reply reply = new Reply();
            reply.setReplyID(replyModel.getReplyID());
            reply.setDescription(replyModel.getDescription());
            reply.setQid(replyModel.getQid());
            reply.setDate(replyModel.getDate());
            reply.setTid(replyModel.getTid());
            reply.setSid(replyModel.getSid());


           replies.add(reply);

        }
        return replies;
    }

    @Override
    public Reply update(Reply reply) {

        ReplyModel replyModel = mongoTemplate.findAndModify(Query.query(Criteria.where("replyID").is(reply.getReplyID())),
                new Update().set("qid",reply.getQid()).set("description",reply.getDescription())
                        .set("tid",reply.getTid()).set("date",reply.getDate()).set("sid",reply.getSid()),ReplyModel.class);

        return reply;
    }

    @Override
    public void delete(String replyID) {
                repository.deleteReplyModelByReplyID(replyID);
    }

    @Override
    public List<Reply> getAllByTeacherID(String tid) {
        List<ReplyModel> replyModels = repository.findReplyModelByTid(tid);
        List<Reply> replies = new ArrayList<>();
        for(ReplyModel replyModel: replyModels){
            Reply reply = new Reply();
            reply.setReplyID(replyModel.getReplyID());
            reply.setDescription(replyModel.getDescription());
            reply.setQid(replyModel.getQid());
            reply.setDate(replyModel.getDate());
            reply.setTid(replyModel.getTid());
            reply.setSid(replyModel.getSid());


            replies.add(reply);

        }
        return replies;
    }

    @Override
    public List<Reply> getAllByStudentID(String sid) {
        List<ReplyModel> replyModels = repository.findReplyModelBySid(sid);
        List<Reply> replies = new ArrayList<>();
        for(ReplyModel replyModel: replyModels){
            Reply reply = new Reply();
            reply.setReplyID(replyModel.getReplyID());
            reply.setDescription(replyModel.getDescription());
            reply.setQid(replyModel.getQid());
            reply.setDate(replyModel.getDate());
            reply.setTid(replyModel.getTid());
            reply.setSid(replyModel.getSid());


            replies.add(reply);

        }
        return replies;
    }
}
