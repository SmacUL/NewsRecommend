package com.smacul.demo.bean;

import java.sql.Timestamp;

public class CusBehaviorRecord {

    private Integer cbrId;
    private Integer cbrCusIdFrom;
    private Integer cbrCusIdTo;
    private Integer cbrBehavior;

    private Timestamp cbrTime;
    private Integer cbrArtId;
    // 行为发生的位置代号, 0: 默认, 1: 文章, 2: 评论, 3:回复
    private Integer cbrType;
    private Integer cbrTargetId;

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

    public Integer getCbrArtId() {
        return cbrArtId;
    }

    public void setCbrArtId(Integer cbrArtId) {
        this.cbrArtId = cbrArtId;
    }

    public Integer getCbrType() {
        return cbrType;
    }

    public void setCbrType(Integer cbrType) {
        this.cbrType = cbrType;
    }

    public Integer getCbrTargetId() {
        return cbrTargetId;
    }

    public void setCbrTargetId(Integer cbrTargetId) {
        this.cbrTargetId = cbrTargetId;
    }
}
