package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticlesMapper;
import com.smacul.demo.dao.CustomersMapper;
import com.smacul.demo.model.ArticleAuthorModel;
import com.smacul.demo.model.HotArticleModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

import java.util.List;

@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    ArticlesMapper articlesMapper;
    @Autowired
    CustomersMapper customersMapper;

    @Autowired
    HttpSession session;

    @Test
    void getArticleMain() {
        System.out.println(articlesMapper.getArticleMain(1));
    }

    @Test
    void getHotArticles() {
    }

    @Test
    void getArticleAuthorByArtId() {
        ArticleAuthorModel articleAuthor = customersMapper.getArticleAuthorByArtId(239);
        System.out.println(articleAuthor.getCusAvatarUrl());
        Integer pageSize = 6;

        List<HotArticleModel> hotArticles = articlesMapper.getRelativeArticles(articleAuthor.getCusId(), pageSize);
        articleAuthor.setHotArticles(hotArticles);
        System.out.println(articleAuthor);
    }
}