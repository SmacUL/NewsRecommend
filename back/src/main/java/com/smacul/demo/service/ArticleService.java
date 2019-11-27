package com.smacul.demo.service;

import com.smacul.demo.model.ArticleAuthorModel;
import com.smacul.demo.model.ArticleModel;
import com.smacul.demo.model.HotArticleModel;

import java.util.List;

public interface ArticleService {
    ArticleModel getArticleMain(Integer id);

    List<HotArticleModel> getHotArticles(String tag, Integer page, Integer pageSize);

    ArticleAuthorModel getArticleAuthorByArtId(Integer artId, Integer pageSize);
}
