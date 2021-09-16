package com.lms.api.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Document(collection = "payment")
public class Payment {
    @MongoId
    private String paymentID;
    private Date issuedDate;
    private String statusMessage;
    private String method;
    private double amount;
    private String currency;
    private int statusCode;
    private String description;
    private String payerName;
    private String payerMobile;
    private String payerEmail;
    private String receiverName;
    private String receiverMobile;
    private String receiverEmail;
}
