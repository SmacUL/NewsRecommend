package com.smacul.demo.model;

import com.smacul.demo.bean.Customer;

import java.sql.Timestamp;

public class ReplyCustomerModel {
    private Integer repId;
    private String repContent;
    // repType 回复的类型, 0 是对评论的回复, 1 是对回复的回复
    private Integer repType;
    private Timestamp repTime;
    private Integer repLikeNum;
    private Integer repDislikeNum;
    // repReplyNum Abandon
    private Integer repReplyNum;
    private Integer repScope;
    private Integer repLegal;
    private String repSpider;
    private Integer repCustomerId;
    private Integer repArticleId;
    private Integer repCommentId;
    private Integer repReplyId;

    private Customer customer;

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

    public Integer getRepType() {
        return repType;
    }

    public void setRepType(Integer repType) {
        this.repType = repType;
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

    public Integer getRepDislikeNum() {
        return repDislikeNum;
    }

    public void setRepDislikeNum(Integer repDislikeNum) {
        this.repDislikeNum = repDislikeNum;
    }

    public Integer getRepReplyNum() {
        return repReplyNum;
    }

    public void setRepReplyNum(Integer repReplyNum) {
        this.repReplyNum = repReplyNum;
    }

    public Integer getRepScope() {
        return repScope;
    }

    public void setRepScope(Integer repScope) {
        this.repScope = repScope;
    }

    public Integer getRepLegal() {
        return repLegal;
    }

    public void setRepLegal(Integer repLegal) {
        this.repLegal = repLegal;
    }

    public String getRepSpider() {
        return repSpider;
    }

    public void setRepSpider(String repSpider) {
        this.repSpider = repSpider;
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

    public Integer getRepCommentId() {
        return repCommentId;
    }

    public void setRepCommentId(Integer repCommentId) {
        this.repCommentId = repCommentId;
    }

    public Integer getRepReplyId() {
        return repReplyId;
    }

    public void setRepReplyId(Integer repReplyId) {
        this.repReplyId = repReplyId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
