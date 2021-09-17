package com.lms.api.dal.adapter;

import com.lms.api.dal.model.NoticeModel;
import com.lms.api.dal.repository.NoticeMongoRepository;
import com.lms.api.domain.Notice;
import com.lms.api.domain.NoticeDataAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticeDataAdapterMongoImpl implements NoticeDataAdapter {

    private final NoticeMongoRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public NoticeDataAdapterMongoImpl(NoticeMongoRepository repository,MongoTemplate mongoTemplate){
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Notice Save(Notice notice) {
        NoticeModel noticeModel = new NoticeModel();
        noticeModel.setDescription(notice.getDescription());
        noticeModel.setTitle(notice.getTitle());
        noticeModel.setDate(notice.getDate());
        noticeModel=repository.save(noticeModel);
        notice.setNoticeID(noticeModel.getNoticeID());
        return notice;
    }

    @Override
    public List<Notice> getAll() {
        List<NoticeModel> noticeModels = repository.findAll();
        List<Notice> notices = new ArrayList<>();
        for(NoticeModel noticeModel: noticeModels){
            Notice notice = new Notice();
            notice.setNoticeID(noticeModel.getNoticeID());
            notice.setDescription(noticeModel.getDescription());
            notice.setDate(noticeModel.getDate());
            notice.setTitle(noticeModel.getTitle());
            notices.add(notice);
        }
        return notices;
    }

    @Override
    public Notice update(Notice notice) {
        NoticeModel noticeModel=mongoTemplate.findAndModify(Query.query(Criteria.where("noticeID").is(notice.getNoticeID())),
                new Update().set("Description",notice.getDescription()).set("Title",notice.getTitle()).set("Date",notice.getDate()),NoticeModel.class);

        return notice;
    }

    @Override
    public void delete(String noticeID) {
        repository.deleteNoticeModelByNoticeID(noticeID);

    }

    @Override
    public List<Notice> getAllByNoticeID(String noticeID) {
        return null;
    }
}
