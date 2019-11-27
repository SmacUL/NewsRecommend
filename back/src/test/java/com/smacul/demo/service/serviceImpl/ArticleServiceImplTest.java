package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticleMapper;
import com.smacul.demo.model.ArticleAuthorModel;
import com.smacul.demo.model.HotArticleModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    HttpSession session;

    @Test
    void getArticleMain() {
        System.out.println(articleMapper.getArticleMain(1));
    }

    @Test
    void getHotArticles() {
    }

    @Test
    void getArticleAuthorByArtId() {
        ArticleAuthorModel articleAuthor = articleMapper.getArticleAuthorByArtId(239);
        System.out.println(articleAuthor.getCusAvatarUrl());
        Integer pageSize = 6;

        List<HotArticleModel> hotArticles = articleMapper.getRelativeArticles(articleAuthor.getCusId(), pageSize);
        articleAuthor.setHotArticles(hotArticles);
        System.out.println(articleAuthor);
    }
}