package com.lms.api.dal.repository;

import com.lms.api.dal.model.QuestionModel;
import com.lms.api.dal.model.ReplyModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyMongRepository extends MongoRepository<ReplyModel,String> {
    void deleteReplyModelByReplyID(String replyID);
    List<ReplyModel> findReplyModelByTid(String tid);
    List<ReplyModel> findReplyModelBySid(String sid);

}
