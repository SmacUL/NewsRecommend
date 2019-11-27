package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.IndexMapper;
import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.model.TinyArticleModel;
import com.smacul.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;

    @Autowired
    HttpSession session;

    @Override
    public List<String> getLeftNavTags() {
        return indexMapper.getLeftNavTags();
    }

    @Override
    public List<TinyArticleModel> getTinyArticles(String tag, Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return indexMapper.getTinyArticles(tag, start, pageSize);
    }

    @Override
    public List<HotArticleModel> getHotArticles(Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return indexMapper.getHotArticles(start, pageSize);
    }
}
