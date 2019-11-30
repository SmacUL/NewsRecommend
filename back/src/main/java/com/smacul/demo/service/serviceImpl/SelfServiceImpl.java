package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticlesMapper;
import com.smacul.demo.dao.CustomersMapper;
import com.smacul.demo.model.CustomerModel;
import com.smacul.demo.model.TinyArticleModel;
import com.smacul.demo.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class SelfServiceImpl implements SelfService {

    @Autowired
    CustomersMapper customersMapper;
    @Autowired
    ArticlesMapper articlesMapper;

    @Autowired
    HttpSession session;

    @Override
    public CustomerModel getCustomerInfoByArtId(Integer artId) {
        return customersMapper.getCustomerInfoByArtId(artId);
    }

    @Override
    public CustomerModel getCustomerInfoByCusId(Integer cusId) {
        return customersMapper.getCustomerInfoByCusId(cusId);
    }

    @Override
    public List<TinyArticleModel> getCustomerArticles(Integer cusId, Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return articlesMapper.getTinyArticlesByCusId(cusId, start, pageSize);
    }
}
