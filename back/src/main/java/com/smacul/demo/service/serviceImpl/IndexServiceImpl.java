package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticlesMapper;
import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.model.TinyArticleModel;
import com.smacul.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {


    @Autowired
    ArticlesMapper articlesMapper;

    @Autowired
    HttpSession session;

    @Override
    public List<String> getLeftNavClasses() {
        return Arrays.asList("社会", "健康");
    }

    @Override
    public List<TinyArticleModel> getTinyArticles(String tag, Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return articlesMapper.getTinyArticles(tag, start, pageSize);
    }

    @Override
    public List<HotArticleModel> getHotArticles(Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return articlesMapper.getHotArticles(start, pageSize);
    }
}
