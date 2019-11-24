package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.ArticleMapper;
import com.smacul.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    HttpSession session;

}
