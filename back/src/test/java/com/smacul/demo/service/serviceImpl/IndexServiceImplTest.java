package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.IndexMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

import java.util.List;

@SpringBootTest
class IndexServiceImplTest {

    @Autowired
    IndexMapper indexMapper;

    @Autowired
    HttpSession session;

    @Test
    void getLeftNavTags() {
        List<String> result = indexMapper.getLeftNavTags();
    }

    @Test
    void getTinyArticles() {
//        List<TinyArticleModel> result = indexMapper.getTinyArticles();
//        TinyArticleModel result = indexMapper.getTinyArticles();
        System.out.println(indexMapper.getTinyArticles("综合", 10, 10));
    }
}