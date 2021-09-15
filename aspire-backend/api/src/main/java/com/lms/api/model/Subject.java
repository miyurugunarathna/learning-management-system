package com.lms.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "Subject")
public class Subject {

    @MongoId
    @Getter(AccessLevel.NONE)
    private ObjectId subjectID;
    private String classID;
    private String subjectName;
    private String description;

    public String getSubjectID() {return subjectID.toString();}
}
