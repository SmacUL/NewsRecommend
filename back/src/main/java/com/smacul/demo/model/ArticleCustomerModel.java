package com.smacul.demo.model;

import com.smacul.demo.bean.Article;
import com.smacul.demo.bean.Customer;

import java.sql.Timestamp;

public class ArticleCustomerModel {
    private Integer artId;
    private String artTitle;
    private String artContent;
    private String artSpider;
    private String artType;
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

    //private Article article;

    private Customer customer;



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

    //public Article getArticle() {
    //    return article;
    //}

    //public void setArticle(Article article) {
    //    this.article = article;
    //}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
