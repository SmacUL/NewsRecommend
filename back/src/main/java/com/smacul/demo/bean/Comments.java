package com.smacul.demo.bean;

import java.sql.Timestamp;

public class Comments {

    private Integer comId;
    private String comContent;
    private Timestamp comTime;
    private Integer comLikeNum;
    private Boolean comLegal;
    private Integer comCustomerId;
    private Integer comArticleId;

    @Override
    public String toString() {
        return "Comments{" +
                "comId=" + comId +
                ", comContent='" + comContent + '\'' +
                ", comTime=" + comTime +
                ", comLikeNum=" + comLikeNum +
                ", comLegal=" + comLegal +
                ", comCustomerId=" + comCustomerId +
                ", comArticleId=" + comArticleId +
                '}';
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Timestamp getComTime() {
        return comTime;
    }

    public void setComTime(Timestamp comTime) {
        this.comTime = comTime;
    }

    public Integer getComLikeNum() {
        return comLikeNum;
    }

    public void setComLikeNum(Integer comLikeNum) {
        this.comLikeNum = comLikeNum;
    }

    public Boolean getComLegal() {
        return comLegal;
    }

    public void setComLegal(Boolean comLegal) {
        this.comLegal = comLegal;
    }

    public Integer getComCustomerId() {
        return comCustomerId;
    }

    public void setComCustomerId(Integer comCustomerId) {
        this.comCustomerId = comCustomerId;
    }

    public Integer getComArticleId() {
        return comArticleId;
    }

    public void setComArticleId(Integer comArticleId) {
        this.comArticleId = comArticleId;
    }



}
