package com.smacul.demo.service;

import com.smacul.demo.model.ArticleCustomerModel;

import java.util.List;

public interface SearchService {
    List<ArticleCustomerModel> searchContentByKeyAndTagTypePage(
            String key, String tag, String type, Integer page, Integer pageSize);
}
