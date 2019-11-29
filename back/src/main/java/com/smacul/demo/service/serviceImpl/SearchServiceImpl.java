package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticlesMapper;
import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.model.TinyArticleModel;
import com.smacul.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ArticlesMapper articlesMapper;

    @Override
    public List<HotArticleModel> getHotArticles(Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return articlesMapper.getHotArticles(start, pageSize);
    }

    @Override
    public List<String> getLeftNavTags() {
        List<String> result = new ArrayList<String>();
        result.add("综合");
        result.add("文章");
        result.add("用户");
        return result;
    }

    @Override
    public List<TinyArticleModel> getTinyArticles(String key, String tag, Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        List<TinyArticleModel> result = null;
        switch (tag) {
            case "综合":
                result = articlesMapper.searchTinyArticles(key, start, pageSize);
                break;
            case "文章":
                result = articlesMapper.searchTinyArticlesByArticle(key, start, pageSize);
                break;
            case "用户":
                result = articlesMapper.searchTinyArticlesByCustomer(key, start, pageSize);
                break;

        }
        return result;
    }
}
