package com.smacul.demo.bean;

import java.sql.Timestamp;

public class Replys {
    private Integer repId;
    private String repContent;
    private Timestamp repTime;
    private Integer repLikeNum;
    private Boolean repLegal;
    private Integer repCustomerId;
    private Integer repArticleId;
    private Integer repReplyId;

    @Override
    public String toString() {
        return "Replys{" +
                "repId=" + repId +
                ", repContent='" + repContent + '\'' +
                ", repTime=" + repTime +
                ", repLikeNum=" + repLikeNum +
                ", repLegal=" + repLegal +
                ", repCustomerId=" + repCustomerId +
                ", repArticleId=" + repArticleId +
                ", repReplyId=" + repReplyId +
                '}';
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public String getRepContent() {
        return repContent;
    }

    public void setRepContent(String repContent) {
        this.repContent = repContent;
    }

    public Timestamp getRepTime() {
        return repTime;
    }

    public void setRepTime(Timestamp repTime) {
        this.repTime = repTime;
    }

    public Integer getRepLikeNum() {
        return repLikeNum;
    }

    public void setRepLikeNum(Integer repLikeNum) {
        this.repLikeNum = repLikeNum;
    }

    public Boolean getRepLegal() {
        return repLegal;
    }

    public void setRepLegal(Boolean repLegal) {
        this.repLegal = repLegal;
    }

    public Integer getRepCustomerId() {
        return repCustomerId;
    }

    public void setRepCustomerId(Integer repCustomerId) {
        this.repCustomerId = repCustomerId;
    }

    public Integer getRepArticleId() {
        return repArticleId;
    }

    public void setRepArticleId(Integer repArticleId) {
        this.repArticleId = repArticleId;
    }

    public Integer getRepReplyId() {
        return repReplyId;
    }

    public void setRepReplyId(Integer repReplyId) {
        this.repReplyId = repReplyId;
    }



}
