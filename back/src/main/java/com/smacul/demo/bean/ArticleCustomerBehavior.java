package com.smacul.demo.bean;

import java.sql.Timestamp;

public class ArticleCustomerBehavior {

    private Integer acbId;
    // acb_behavior 用户行为: 无 0, 写作 1, 点赞 2, 点踩 3, 评论 4, 回复 5, 浏览 6
    private Integer acbBehavior;
    private Timestamp acbTime;
    private Integer acbArticleId;
    private Integer acbCustomerId;

    public Integer getAcbId() {
        return acbId;
    }

    public void setAcbId(Integer acbId) {
        this.acbId = acbId;
    }

    public Integer getAcbBehavior() {
        return acbBehavior;
    }

    public void setAcbBehavior(Integer acbBehavior) {
        this.acbBehavior = acbBehavior;
    }

    public Timestamp getAcbTime() {
        return acbTime;
    }

    public void setAcbTime(Timestamp acbTime) {
        this.acbTime = acbTime;
    }

    public Integer getAcbArticleId() {
        return acbArticleId;
    }

    public void setAcbArticleId(Integer acbArticleId) {
        this.acbArticleId = acbArticleId;
    }

    public Integer getAcbCustomerId() {
        return acbCustomerId;
    }

    public void setAcbCustomerId(Integer acbCustomerId) {
        this.acbCustomerId = acbCustomerId;
    }

    @Override
    public String toString() {
        return "ArticleCustomerBehavior{" +
                "acbId=" + acbId +
                ", acbBehavior=" + acbBehavior +
                ", acbTime=" + acbTime +
                ", acbArticleId=" + acbArticleId +
                ", acbCustomerId=" + acbCustomerId +
                '}';
    }

}
