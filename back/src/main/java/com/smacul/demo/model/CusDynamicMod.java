package com.smacul.demo.model;

import com.smacul.demo.bean.Customer;

import java.sql.Timestamp;

public class CusDynamicMod {

    private Integer cbrId;
    private Integer cbrCusIdFrom;
    private Integer cbrCusIdTo;
    private Integer cbrBehavior;
    private Timestamp cbrTime;
    // 行为发生的位置代号, 0: 默认, 1: 文章, 2: 评论, 3:回复
    private Integer cbrType;
    private Integer cbrArtId;

    private Customer cusFrom;
    private Customer cusTo;
    private ArtFullMod article;
    private ComFullMod comment;
    private RepFullMod reply;

    public Integer getCbrId() {
        return cbrId;
    }

    public void setCbrId(Integer cbrId) {
        this.cbrId = cbrId;
    }

    public Integer getCbrCusIdFrom() {
        return cbrCusIdFrom;
    }

    public void setCbrCusIdFrom(Integer cbrCusIdFrom) {
        this.cbrCusIdFrom = cbrCusIdFrom;
    }

    public Integer getCbrCusIdTo() {
        return cbrCusIdTo;
    }

    public void setCbrCusIdTo(Integer cbrCusIdTo) {
        this.cbrCusIdTo = cbrCusIdTo;
    }

    public Integer getCbrBehavior() {
        return cbrBehavior;
    }

    public void setCbrBehavior(Integer cbrBehavior) {
        this.cbrBehavior = cbrBehavior;
    }

    public Timestamp getCbrTime() {
        return cbrTime;
    }

    public void setCbrTime(Timestamp cbrTime) {
        this.cbrTime = cbrTime;
    }

    public Integer getCbrType() {
        return cbrType;
    }

    public void setCbrType(Integer cbrType) {
        this.cbrType = cbrType;
    }

    public Customer getCusFrom() {
        return cusFrom;
    }

    public void setCusFrom(Customer cusFrom) {
        this.cusFrom = cusFrom;
    }

    public Customer getCusTo() {
        return cusTo;
    }

    public void setCusTo(Customer cusTo) {
        this.cusTo = cusTo;
    }

    public ArtFullMod getArticle() {
        return article;
    }

    public void setArticle(ArtFullMod article) {
        this.article = article;
    }

    public ComFullMod getComment() {
        return comment;
    }

    public void setComment(ComFullMod comment) {
        this.comment = comment;
    }

    public RepFullMod getReply() {
        return reply;
    }

    public void setReply(RepFullMod reply) {
        this.reply = reply;
    }

    public Integer getCbrArtId() {
        return cbrArtId;
    }

    public void setCbrArtId(Integer cbrArtId) {
        this.cbrArtId = cbrArtId;
    }
}
