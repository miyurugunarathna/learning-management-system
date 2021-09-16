package com.lms.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "coursetopic")
public class CourseTopic {
    @MongoId
    @Getter(AccessLevel.NONE)
    private ObjectId coursetopicID;
    private String classID;
    private String subjectID;
    private String teacherID;
    private String title;
    private String description;
    private String url;


    public String getCoursetopicID() {return coursetopicID.toString();}

}
