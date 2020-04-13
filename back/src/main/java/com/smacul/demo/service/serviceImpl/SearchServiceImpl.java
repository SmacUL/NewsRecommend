package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticlesDao;
import com.smacul.demo.model.ArticleCustomerModel;
import com.smacul.demo.service.SearchService;
import com.smacul.demo.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ArticlesDao articlesDao;

    /**
     * 在这个方法中, tag 并不会被直接使用, 还没想好前端应该如何处理
     *
     * @param key
     * @param tag
     * @param type
     * @return
     */
    @Override
    public List<ArticleCustomerModel> searchContentByKeyAndTagTypePage(
            String key, String tag, String type, Integer page, Integer pageSize) {
        Integer start = PageHandler.calcuStartNO(page, pageSize);
        key = "%" + key + "%";

        if ("author".equals(tag)) {
            return articlesDao.searchContentAuthor(key, start, pageSize);
        } else if ("article".equals(tag)) {
            return articlesDao.searchContentArticle(key, start, pageSize);
        } else {
            return articlesDao.searchContentGlobal(key, start, pageSize);
        }
    }
}
