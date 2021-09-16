package com.lms.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "badge")

public class Badge {

    @Id
    public String badgeID;
    private String badgeName;
    private String description;
    private String condition;
    private String createdDate;
    private String modifiedDate;
    private String subjectID;
    private String classID;

    public Badge() {
    }

//    public Badge(String badgeID, String badgeName, String description, String condition, String createdDate, String modifiedDate) {
//        this.badgeID = badgeID;
//        this.badgeName = badgeName;
//        this.description = description;
//        this.condition = condition;
//        this.createdDate = createdDate;
//        this.modifiedDate = modifiedDate;
//    }


    public Badge(String badgeID, String badgeName, String description, String condition, String createdDate, String modifiedDate, String subjectID, String classID) {
        this.badgeID = badgeID;
        this.badgeName = badgeName;
        this.description = description;
        this.condition = condition;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.subjectID = subjectID;
        this.classID = classID;
    }

    public String getBadgeID() {
        return badgeID;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public String getDescription() {
        return description;
    }

    public String getCondition() {
        return condition;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setBadgeID(String badgeID) {
        this.badgeID = badgeID;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public String getClassID() {
        return classID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "Badge {" +
                " Badge ID : " + badgeID + "\n" +
                " Badge Name : " + badgeName + "\n" +
                " Description : " + description + "\n" +
                " Condition : " + condition + "\n" +
                " Created Date : " + createdDate + "\n" +
                " Modified Date : " + modifiedDate + "\n" +
                " }";
    }
}