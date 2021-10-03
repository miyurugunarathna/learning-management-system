package com.lms.api.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("enquiries")
public class EnquiryModel {

    @Id
    private String enquiryid;
    private String name;
    private String email;
    private String message;

    public String getEnquiryid() {
        return enquiryid;
    }

    public void setEnquiryid(String enquiryid) {
        this.enquiryid = enquiryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
