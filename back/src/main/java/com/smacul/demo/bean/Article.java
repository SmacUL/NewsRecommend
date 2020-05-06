package com.smacul.demo.bean;

import java.sql.Timestamp;

public class Article {
    private Integer artId;
    private String artTitle;
    private String artContent;
    private String artSpider;

    private String artType;
    private String artTags;
    private String artImageUrl;
    private Timestamp artTime;

    private Integer artLegal;
    private Integer artCusId;

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

    public String getArtSpider() {
        return artSpider;
    }

    public void setArtSpider(String artSpider) {
        this.artSpider = artSpider;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public String getArtTags() {
        return artTags;
    }

    public void setArtTags(String artTags) {
        this.artTags = artTags;
    }

    public String getArtImageUrl() {
        return artImageUrl;
    }

    public void setArtImageUrl(String artImageUrl) {
        this.artImageUrl = artImageUrl;
    }

    public Timestamp getArtTime() {
        return artTime;
    }

    public void setArtTime(Timestamp artTime) {
        this.artTime = artTime;
    }

    public Integer getArtLegal() {
        return artLegal;
    }

    public void setArtLegal(Integer artLegal) {
        this.artLegal = artLegal;
    }

    public Integer getArtCusId() {
        return artCusId;
    }

    public void setArtCusId(Integer artCusId) {
        this.artCusId = artCusId;
    }
}
