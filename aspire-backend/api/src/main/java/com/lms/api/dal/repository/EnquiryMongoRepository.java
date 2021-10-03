package com.lms.api.dal.repository;

import com.lms.api.dal.model.EnquiryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryMongoRepository extends MongoRepository<EnquiryModel,String> {
    void deleteEnquiryModelByEnquiryid(String enqiryid);
}
