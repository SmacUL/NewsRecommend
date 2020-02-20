package com.smacul.demo.service;

import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.model.TinyArticleModel;

import java.util.List;

public interface IndexService {
    List<String> getLeftNavClasses();

    List<TinyArticleModel> getTinyArticles(String tag, Integer page, Integer pageSize);

    List<HotArticleModel> getHotArticles(Integer page, Integer pageSize);
}
