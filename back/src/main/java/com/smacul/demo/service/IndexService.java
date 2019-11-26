package com.smacul.demo.service;

import com.smacul.demo.model.TinyArticleModel;

import java.util.List;

public interface IndexService {
    List<String> getLeftNavTags();

    List<TinyArticleModel> getTinyArticles(String tag, Integer page, Integer pageSize);
}
