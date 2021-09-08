package com.lms.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "fee")
public class Fee {

    @MongoId
    @Getter(AccessLevel.NONE)
    private ObjectId feeID;
    private String feeName;
    private String feeType;
    private double amount;
    private int frequency;

    public String getFeeID() {
        return feeID.toString();
    }
}
