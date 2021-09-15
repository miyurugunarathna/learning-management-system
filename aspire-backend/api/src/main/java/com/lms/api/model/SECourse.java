package com.lms.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "StudentEnrollCourse")
public class SECourse {
    @MongoId
    @Getter(AccessLevel.NONE)
    private ObjectId secourseID;
    private String classID;
    private String subjectID;
    private String teacherID;
    private String studentID;

    public String getSECourse() {return secourseID.toString();}
}
