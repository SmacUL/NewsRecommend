package com.smacul.demo.model;

import com.smacul.demo.bean.ArtFeatureCount;
import com.smacul.demo.bean.Customer;

import java.sql.Timestamp;

public class ArtFullMod {
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

    // 文章作者
    private Customer customer;
    private ArtFeatureCount artFeature;
    // 浏览者-文章的行为
    private CusArtBehaviorMod cusArtBehavior;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArtFeatureCount getArtFeature() {
        return artFeature;
    }

    public void setArtFeature(ArtFeatureCount artFeature) {
        this.artFeature = artFeature;
    }

    public CusArtBehaviorMod getCusArtBehavior() {
        return cusArtBehavior;
    }

    public void setCusArtBehavior(CusArtBehaviorMod cusArtBehavior) {
        this.cusArtBehavior = cusArtBehavior;
    }
}
