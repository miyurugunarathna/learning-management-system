package com.lms.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "courseattachment")
public class CourseAttachment {
    @MongoId
    @Getter(AccessLevel.NONE)
    private ObjectId courseattachmentID;
    private String classID;
    private String subjectID;
    private String teacherID;
    private String title;
    private String url;

    public String getCourseattachmentID() {return courseattachmentID.toString();}
}
