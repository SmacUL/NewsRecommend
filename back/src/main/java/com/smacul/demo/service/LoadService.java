package com.smacul.demo.service;

import com.smacul.demo.bean.Article;
import com.smacul.demo.model.ArticleCustomerModel;

import java.util.List;

public interface LoadService {

    List<String> getArtTypes();

    List<ArticleCustomerModel> getTinyArtOnePageByType(String artClass, Integer page, Integer pageSize);

    List<ArticleCustomerModel> getHotArtOnePage(Integer page, Integer pageSize);

    ArticleCustomerModel getFullArtWithCus(Integer artId);

    Boolean cusArtPreference(Integer artId, Boolean preference);
}
