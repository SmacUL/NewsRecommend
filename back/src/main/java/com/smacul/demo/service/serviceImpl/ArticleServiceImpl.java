package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticleMapper;
import com.smacul.demo.model.ArticleAuthorModel;
import com.smacul.demo.model.ArticleModel;
import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    HttpSession session;


    @Override
    public ArticleModel getArticleMain(Integer id) {
        return articleMapper.getArticleMain(id);
    }

    @Override
    public List<HotArticleModel> getHotArticles(String tag, Integer page, Integer pageSize) {
        Integer start = page * pageSize;
        return articleMapper.getHotArticles(tag, start, pageSize);
    }

    @Override
    public ArticleAuthorModel getArticleAuthorByArtId(Integer artId, Integer pageSize) {
        ArticleAuthorModel articleAuthor = articleMapper.getArticleAuthorByArtId(artId);
        List<HotArticleModel> hotArticles = articleMapper.getRelativeArticles(articleAuthor.getCusId(), pageSize);
        articleAuthor.setHotArticles(hotArticles);
        return articleAuthor;
    }
}
