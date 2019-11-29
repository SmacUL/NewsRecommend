package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticlesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

import java.util.List;

@SpringBootTest
class IndexServiceImplTest {

    @Autowired
    ArticlesMapper articlesMapper;

    @Autowired
    HttpSession session;

    @Test
    void getLeftNavTags() {
        List<String> result = articlesMapper.getLeftNavTags();
    }

    @Test
    void getTinyArticles() {
//        List<TinyArticleModel> result = indexMapper.getTinyArticles();
//        TinyArticleModel result = indexMapper.getTinyArticles();
        System.out.println(articlesMapper.getTinyArticles("综合", 10, 10));
    }
}