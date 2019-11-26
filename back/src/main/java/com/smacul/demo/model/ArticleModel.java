package com.smacul.demo.model;

import java.sql.Timestamp;

public class ArticleModel {
    private Integer artId;
    private String artTitle;
    private String artContent;
    private String artTag;
    private Integer artLikeNum;
    private Integer artDislikeNum;
    private Timestamp artTime;
    private String cusName;


    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    public String getArtTag() {
        return artTag;
    }

    public void setArtTag(String artTag) {
        this.artTag = artTag;
    }

    public Integer getArtLikeNum() {
        return artLikeNum;
    }

    public void setArtLikeNum(Integer artLikeNum) {
        this.artLikeNum = artLikeNum;
    }

    public Integer getArtDislikeNum() {
        return artDislikeNum;
    }

    public void setArtDislikeNum(Integer artDislikeNum) {
        this.artDislikeNum = artDislikeNum;
    }

    public Timestamp getArtTime() {
        return artTime;
    }

    public void setArtTime(Timestamp artTime) {
        this.artTime = artTime;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

}
