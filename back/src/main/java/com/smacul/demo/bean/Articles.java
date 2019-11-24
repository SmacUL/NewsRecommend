package com.smacul.demo.bean;

import java.sql.Timestamp;

public class Articles {
    private Integer artId;
    private String artTitle;
    private String artAbstract;
    private String artContent;
    private String artUrl;
    private String artTag;
    private Integer artLikeNum;
    private Integer artDislikeNum;
    private Timestamp artTime;
    private Boolean artLegal;
    private Integer artCustomerId;
    private String artImage;

    @Override
    public String toString() {
        return "Articles{" +
                "artId=" + artId +
                ", artTitle='" + artTitle + '\'' +
                ", artAbstract='" + artAbstract + '\'' +
                ", artContent='" + artContent + '\'' +
                ", artUrl='" + artUrl + '\'' +
                ", artTag='" + artTag + '\'' +
                ", artLikeNum=" + artLikeNum +
                ", artDislikeNum=" + artDislikeNum +
                ", artTime=" + artTime +
                ", artLegal=" + artLegal +
                ", artCustomerId=" + artCustomerId +
                ", artImage='" + artImage + '\'' +
                '}';
    }

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

    public String getArtAbstract() {
        return artAbstract;
    }

    public void setArtAbstract(String artAbstract) {
        this.artAbstract = artAbstract;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
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

    public Boolean getArtLegal() {
        return artLegal;
    }

    public void setArtLegal(Boolean artLegal) {
        this.artLegal = artLegal;
    }

    public Integer getArtCustomerId() {
        return artCustomerId;
    }

    public void setArtCustomerId(Integer artCustomerId) {
        this.artCustomerId = artCustomerId;
    }

    public String getArtImage() {
        return artImage;
    }

    public void setArtImage(String artImage) {
        this.artImage = artImage;
    }


}
