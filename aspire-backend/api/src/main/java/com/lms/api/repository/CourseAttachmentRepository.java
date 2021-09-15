package com.lms.api.repository;

import com.lms.api.model.CourseAttachment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAttachmentRepository extends MongoRepository <CourseAttachment, String>{

}
