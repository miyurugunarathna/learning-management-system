package com.lms.api.dal.adapter;

import com.lms.api.dal.model.EnquiryModel;
import com.lms.api.dal.model.NoticeModel;
import com.lms.api.dal.repository.EnquiryMongoRepository;
import com.lms.api.dal.repository.NoticeMongoRepository;
import com.lms.api.domain.Enquiry;
import com.lms.api.domain.EnquiryDataAdapter;
import com.lms.api.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnquiryDataAdapterMongoImpl implements EnquiryDataAdapter {
    private final EnquiryMongoRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public EnquiryDataAdapterMongoImpl(EnquiryMongoRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Enquiry Save(Enquiry enquiry) {
        EnquiryModel enquiryModel = new EnquiryModel();
        enquiryModel.setName(enquiry.getName());
        enquiryModel.setEmail(enquiry.getEmail());
        enquiryModel.setMessage(enquiry.getMessage());
        enquiryModel=repository.save(enquiryModel);
        enquiry.setEnquiryid(enquiryModel.getEnquiryid());
        return enquiry;
    }

    @Override
    public List<Enquiry> getAll() {
        List<EnquiryModel> enquiryModels = repository.findAll();
        List<Enquiry> enquiries = new ArrayList<>();
        for(EnquiryModel enquiryModel: enquiryModels){
            Enquiry enquiry = new Enquiry();
            enquiry.setEnquiryid(enquiryModel.getEnquiryid());
            enquiry.setName(enquiryModel.getName());
            enquiry.setEmail(enquiryModel.getEmail());
            enquiry.setMessage(enquiryModel.getMessage());

            enquiries.add(enquiry);
        }
        return enquiries;

    }

    @Override
    public void delete(String enquiryid) {
            repository.deleteEnquiryModelByEnquiryid(enquiryid);
    }
}
