package com.lms.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "Classes")
public class Classes {

    @MongoId
    @Getter(AccessLevel.NONE)
    private ObjectId classID;
    private String className;
    private String createdDate;

    public String getClassID() {return classID.toString();}
}
