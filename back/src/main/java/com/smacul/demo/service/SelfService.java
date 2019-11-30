package com.smacul.demo.service;

import com.smacul.demo.model.CustomerModel;
import com.smacul.demo.model.TinyArticleModel;

import java.util.List;

public interface SelfService {
    CustomerModel getCustomerInfoByArtId(Integer artId);
    CustomerModel getCustomerInfoByCusId(Integer cusId);

    List<TinyArticleModel> getCustomerArticles(Integer cusId, Integer page, Integer pageSize);
}
