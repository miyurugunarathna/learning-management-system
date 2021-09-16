package com.lms.api.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("marks")
public class MarksModel {

    @Id
    private String mid;
    private String sid;
    private int q_marks;
    private String key;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getQ_marks() {
        return q_marks;
    }

    public void setQ_marks(int q_marks) {
        this.q_marks = q_marks;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
