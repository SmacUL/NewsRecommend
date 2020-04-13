package com.smacul.demo.model;

import com.smacul.demo.bean.Customer;

import java.sql.Timestamp;
import java.util.List;

public class CommentCustomerModel {

    private Integer comId;
    private String comContent;
    private Timestamp comTime;
    private Integer comLikeNum;
    private Integer comDislikeNum;
    // comReplyNum Abandon
    private Integer comReplyNum;
    private Integer comScope;
    private Integer comLegal;
    private String comSpider;
    private Integer comCustomerId;
    private Integer comArticleId;

    private Customer customer;

    private List<ReplyCustomerModel> replys;

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

    public Integer getComDislikeNum() {
        return comDislikeNum;
    }

    public void setComDislikeNum(Integer comDislikeNum) {
        this.comDislikeNum = comDislikeNum;
    }

    public Integer getComReplyNum() {
        return comReplyNum;
    }

    public void setComReplyNum(Integer comReplyNum) {
        this.comReplyNum = comReplyNum;
    }

    public Integer getComScope() {
        return comScope;
    }

    public void setComScope(Integer comScope) {
        this.comScope = comScope;
    }

    public Integer getComLegal() {
        return comLegal;
    }

    public void setComLegal(Integer comLegal) {
        this.comLegal = comLegal;
    }

    public String getComSpider() {
        return comSpider;
    }

    public void setComSpider(String comSpider) {
        this.comSpider = comSpider;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ReplyCustomerModel> getReplys() {
        return replys;
    }

    public void setReplys(List<ReplyCustomerModel> replys) {
        this.replys = replys;
    }
}
