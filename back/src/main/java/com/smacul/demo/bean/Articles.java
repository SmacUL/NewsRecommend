package com.smacul.demo.bean;

import java.sql.Timestamp;

public class Articles {
    private Integer artId;
    private String artTitle;
    private String artContent;
    private String artSpider;
    private String artClass;
    // artTag 文章的标签 应该以 & 分隔
    private String artTag;
    private String artImageUrl;
    private Integer artLikeNum;
    private Integer artDislikeNum;
    private Timestamp artTime;
    private Integer artCommentNum;
    private Integer artScope;
    private Integer getLegal;
    private Integer artCustomerId;

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

    public String getArtClass() {
        return artClass;
    }

    public void setArtClass(String artClass) {
        this.artClass = artClass;
    }

    public String getArtTag() {
        return artTag;
    }

    public void setArtTag(String artTag) {
        this.artTag = artTag;
    }

    public String getArtImageUrl() {
        return artImageUrl;
    }

    public void setArtImageUrl(String artImageUrl) {
        this.artImageUrl = artImageUrl;
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

    public Integer getArtCommentNum() {
        return artCommentNum;
    }

    public void setArtCommentNum(Integer artCommentNum) {
        this.artCommentNum = artCommentNum;
    }

    public Integer getArtScope() {
        return artScope;
    }

    public void setArtScope(Integer artScope) {
        this.artScope = artScope;
    }

    public Integer getGetLegal() {
        return getLegal;
    }

    public void setGetLegal(Integer getLegal) {
        this.getLegal = getLegal;
    }

    public Integer getArtCustomerId() {
        return artCustomerId;
    }

    public void setArtCustomerId(Integer artCustomerId) {
        this.artCustomerId = artCustomerId;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "artId=" + artId +
                ", artTitle='" + artTitle + '\'' +
                ", artContent='" + artContent + '\'' +
                ", artSpider='" + artSpider + '\'' +
                ", artClass='" + artClass + '\'' +
                ", artTag='" + artTag + '\'' +
                ", artImageUrl='" + artImageUrl + '\'' +
                ", artLikeNum=" + artLikeNum +
                ", artDislikeNum=" + artDislikeNum +
                ", artTime=" + artTime +
                ", artCommentNum=" + artCommentNum +
                ", artScope=" + artScope +
                ", getLegal=" + getLegal +
                ", artCustomerId=" + artCustomerId +
                '}';
    }
}
