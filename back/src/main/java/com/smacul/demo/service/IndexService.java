package com.smacul.demo.service;

import com.smacul.demo.model.TinyArticle;

import java.util.List;

public interface IndexService {
    List<String> getLeftNavTags();

    List<TinyArticle> getTinyArticles(String tag, Integer page, Integer pageSize);
}
