package com.smacul.demo.bean;

import java.sql.Timestamp;

public class Customers {
    private Integer cusId;
    private String cusName;
    private String cusPass;
    private String cusEmail;
    private String cusPhone;
    private String cusAddress;
    private String cusAvatarUrl;
    private String cusStyle;
    private Integer cusGender;
    private Timestamp cusTime;
    private Integer cusType;
    private Boolean cusLegal;

    @Override
    public String toString() {
        return "Customers{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusPass='" + cusPass + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", cusPhone='" + cusPhone + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusAvatarUrl='" + cusAvatarUrl + '\'' +
                ", cusStyle='" + cusStyle + '\'' +
                ", cusGender=" + cusGender +
                ", cusTime=" + cusTime +
                ", cusType=" + cusType +
                ", cusLegal=" + cusLegal +
                '}';
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPass() {
        return cusPass;
    }

    public void setCusPass(String cusPass) {
        this.cusPass = cusPass;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusAvatarUrl() {
        return cusAvatarUrl;
    }

    public void setCusAvatarUrl(String cusAvatarUrl) {
        this.cusAvatarUrl = cusAvatarUrl;
    }

    public String getCusStyle() {
        return cusStyle;
    }

    public void setCusStyle(String cusStyle) {
        this.cusStyle = cusStyle;
    }

    public Integer getCusGender() {
        return cusGender;
    }

    public void setCusGender(Integer cusGender) {
        this.cusGender = cusGender;
    }

    public Timestamp getCusTime() {
        return cusTime;
    }

    public void setCusTime(Timestamp cusTime) {
        this.cusTime = cusTime;
    }

    public Integer getCusType() {
        return cusType;
    }

    public void setCusType(Integer cusType) {
        this.cusType = cusType;
    }

    public Boolean getCusLegal() {
        return cusLegal;
    }

    public void setCusLegal(Boolean cusLegal) {
        this.cusLegal = cusLegal;
    }


}
