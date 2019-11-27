package com.smacul.demo.controller;

import com.smacul.demo.model.ArticleAuthorModel;
import com.smacul.demo.model.ArticleModel;
import com.smacul.demo.model.HotArticleModel;
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

    /**
     * 获取文章的主体内容
     *
     * @param id
     * @return
     */
    @RequestMapping("/main")
    public ArticleModel getArticleMain(@RequestParam Integer id) {
        return articleService.getArticleMain(id);
    }

    /**
     * 获取热点文章的列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/hot")
    public List<HotArticleModel> getHotArticles(@RequestParam String tag,
                                                @RequestParam Integer page, @RequestParam Integer pageSize) {
        return articleService.getHotArticles(tag, page, pageSize);
    }

    @RequestMapping("/author")
    public ArticleAuthorModel getArticleAuthorByArtId(@RequestParam Integer artId, @RequestParam Integer pageSize) {
        return articleService.getArticleAuthorByArtId(artId, pageSize);
    }

}
