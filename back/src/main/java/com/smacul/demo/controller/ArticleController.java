package com.smacul.demo.controller;

import com.smacul.demo.model.ArticleModel;
import com.smacul.demo.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @RequestMapping("/main")
    public ArticleModel getArticleMain(@RequestParam Integer id) {
        return articleService.getArticleMain(id);
    }

}
