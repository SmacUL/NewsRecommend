package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

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
}