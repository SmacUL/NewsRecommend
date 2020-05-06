package com.smacul.demo.bean;


import java.sql.Timestamp;

public class Customer {
    private Integer cusId;
    private String cusName;
    private String cusPass;
    private String cusSpider;

    private String cusAvatarUrl;
    private String cusStyle;
    private Integer cusGender;
    private Timestamp cusTime;
    // cusLegal 默认为 0, 1 为合法, -1 为非法
    private Integer cusLegal;

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

    public String getCusSpider() {
        return cusSpider;
    }

    public void setCusSpider(String cusSpider) {
        this.cusSpider = cusSpider;
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

    public Integer getCusLegal() {
        return cusLegal;
    }

    public void setCusLegal(Integer cusLegal) {
        this.cusLegal = cusLegal;
    }
}
