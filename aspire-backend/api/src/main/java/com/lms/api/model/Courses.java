package com.lms.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "Courses")
public class Courses {
    @MongoId
    @Getter(AccessLevel.NONE)
    private ObjectId coursesID;
    private String classID;
    private String subjectID;
    private String teacherID;
    private String description;

    public String getCoursesID() {return coursesID.toString();}
}
