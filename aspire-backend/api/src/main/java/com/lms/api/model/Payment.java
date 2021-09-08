package com.lms.api.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "payment")
public class Payment {
    @MongoId
    private ObjectId paymentID;
    private Date issuedDate;
    private String statusMessage;
    private String method;
    private double amount;
    private String currency;
    private int statusCode;
    private String description;
    private String studentID;
    private String classID;
    private String subjectID;
    private ObjectId feeID;
    private List<Fee> fees;
}
