package com.lms.api.model;

//import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "package")
public class Package {

    @Transient
    public static final String SEQUENCE_NAME="users_sequence";

    @Id
    private long id;

    //  @NotBlank
    //  @Size(max=100)
    @Indexed(unique = true)
    private String packageName;
    private int maxCourse;
    private int maxStudent;
    private double commission;
    private int comType;
    private double annualFee;
    private double monthlyFee;
    private boolean defaultPack;
    private String createdDate;
    private String modifiedDate;

    public Package() {
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", packageName='" + packageName + '\'' +
                ", maxCourse=" + maxCourse +
                ", maxStudent=" + maxStudent +
                ", commission=" + commission +
                ", comType=" + comType +
                ", annualFee=" + annualFee +
                ", monthlyFee=" + monthlyFee +
                ", defaultPack=" + defaultPack +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }

    public Package(long id, String packageName, int maxCourse, int maxStudent, double commission, int comType, double annualFee, double monthlyFee, boolean defaultPack, String createdDate, String modifiedDate) {
        this.id = id;
        this.packageName = packageName;
        this.maxCourse = maxCourse;
        this.maxStudent = maxStudent;
        this.commission = commission;
        this.comType = comType;
        this.annualFee = annualFee;
        this.monthlyFee = monthlyFee;
        this.defaultPack = defaultPack;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getMaxCourse() {
        return maxCourse;
    }

    public void setMaxCourse(int maxCourse) {
        this.maxCourse = maxCourse;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public int getComType() {
        return comType;
    }

    public void setComType(int comType) {
        this.comType = comType;
    }

    public double getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(double annualFee) {
        this.annualFee = annualFee;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public boolean isDefaultPack() {
        return defaultPack;
    }

    public void setDefaultPack(boolean defaultPack) {
        this.defaultPack = defaultPack;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


}
