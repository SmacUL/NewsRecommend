package com.smacul.demo.service;

import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.model.TinyArticleModel;

import java.util.List;

public interface SearchService {
    List<HotArticleModel> getHotArticles(Integer page, Integer pageSize);

    List<String> getLeftNavTags();

    List<TinyArticleModel> getTinyArticles(String key, String tag, Integer page, Integer pageSize);
}
