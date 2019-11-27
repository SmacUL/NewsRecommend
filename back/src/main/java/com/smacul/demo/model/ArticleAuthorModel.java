package com.smacul.demo.model;

import java.util.List;

public class ArticleAuthorModel {
    private Integer cusId;
    private String cusName;
    private String cusAvatarUrl;
    private List<HotArticleModel> hotArticles;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAvatarUrl() {
        return cusAvatarUrl;
    }

    public void setCusAvatarUrl(String cusAvatarUrl) {
        this.cusAvatarUrl = cusAvatarUrl;
    }

    public List<HotArticleModel> getHotArticles() {
        return hotArticles;
    }

    public void setHotArticles(List<HotArticleModel> hotArticles) {
        this.hotArticles = hotArticles;
    }

}
