package com.smacul.demo.bean;

import java.sql.Timestamp;

public class Customer {

    private Integer cusId;
    private String cusName;
    private String cusPass;
    private String cusSpider;
    private String cusAvatarUrl;
    private String cusBackgroundUrl;
    private String cusStyle;
    // cus_gender 为 0 时性别未知, 为 1 时为男, 为 -1 时为女
    private Integer cusGender;
    private Timestamp cusTime;
    // cus_type 为 0 时是普通用户, 为 1 时是可编辑用户
    private Integer cusType;
    private Integer cusFollowNum;
    private Integer cusFanNum;
    private Integer cusArticleNum;
    private Integer cusScope;
    // cus_legal 为 0 时待审核, 为 1 时合法, 为 -1 不合法
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

    public String getCusBackgroundUrl() {
        return cusBackgroundUrl;
    }

    public void setCusBackgroundUrl(String cusBackgroundUrl) {
        this.cusBackgroundUrl = cusBackgroundUrl;
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

    public Integer getCusFollowNum() {
        return cusFollowNum;
    }

    public void setCusFollowNum(Integer cusFollowNum) {
        this.cusFollowNum = cusFollowNum;
    }

    public Integer getCusFanNum() {
        return cusFanNum;
    }

    public void setCusFanNum(Integer cusFanNum) {
        this.cusFanNum = cusFanNum;
    }

    public Integer getCusArticleNum() {
        return cusArticleNum;
    }

    public void setCusArticleNum(Integer cusArticleNum) {
        this.cusArticleNum = cusArticleNum;
    }

    public Integer getCusScope() {
        return cusScope;
    }

    public void setCusScope(Integer cusScope) {
        this.cusScope = cusScope;
    }

    public Integer getCusLegal() {
        return cusLegal;
    }

    public void setCusLegal(Integer cusLegal) {
        this.cusLegal = cusLegal;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusPass='" + cusPass + '\'' +
                ", cusSpider='" + cusSpider + '\'' +
                ", cusAvatarUrl='" + cusAvatarUrl + '\'' +
                ", cusBackgroundUrl='" + cusBackgroundUrl + '\'' +
                ", cusStyle='" + cusStyle + '\'' +
                ", cusGender=" + cusGender +
                ", cusTime=" + cusTime +
                ", cusType=" + cusType +
                ", cusFollowNum=" + cusFollowNum +
                ", cusFanNum=" + cusFanNum +
                ", cusArticleNum=" + cusArticleNum +
                ", cusScope=" + cusScope +
                ", cusLegal=" + cusLegal +
                '}';
    }

}
