package com.smacul.demo.model;

import com.smacul.demo.bean.Article;
import com.smacul.demo.bean.ArticleFeatureCount;
import com.smacul.demo.bean.Customer;

public class CustomerDynamicModel {
    private Integer acbCustomerId;
    // 无 0, 写作 1, 点赞 2, 点踩 3, 评论 4, 回复 5(包括对回复的回复), 浏览 6
    private Integer acbBehavior;
    private ArticleCustomerModel artWithCus;
    private ArticleFeatureCount feature;

    public Integer getAcbCustomerId() {
        return acbCustomerId;
    }

    public void setAcbCustomerId(Integer acbCustomerId) {
        this.acbCustomerId = acbCustomerId;
    }

    public Integer getAcbBehavior() {
        return acbBehavior;
    }

    public void setAcbBehavior(Integer acbBehavior) {
        this.acbBehavior = acbBehavior;
    }

    public ArticleCustomerModel getArtWithCus() {
        return artWithCus;
    }

    public void setArtWithCus(ArticleCustomerModel artWithCus) {
        this.artWithCus = artWithCus;
    }

    public ArticleFeatureCount getFeature() {
        return feature;
    }

    public void setFeature(ArticleFeatureCount feature) {
        this.feature = feature;
    }

}
