package com.smacul.demo.model;

public class CustomerBehaviorCountModel {
    private Integer cusId;
    private Integer followNum;
    private Integer fanNum;
    private Integer writeNum;
    // 包括评论与回复
    private Integer beLikedNum;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public Integer getFanNum() {
        return fanNum;
    }

    public void setFanNum(Integer fanNum) {
        this.fanNum = fanNum;
    }

    public Integer getWriteNum() {
        return writeNum;
    }

    public void setWriteNum(Integer writeNum) {
        this.writeNum = writeNum;
    }

    public Integer getBeLikedNum() {
        return beLikedNum;
    }

    public void setBeLikedNum(Integer beLikedNum) {
        this.beLikedNum = beLikedNum;
    }
}
