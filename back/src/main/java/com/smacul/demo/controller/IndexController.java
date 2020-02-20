package com.smacul.demo.controller;


import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.model.TinyArticleModel;
import com.smacul.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    IndexService indexService;

    @RequestMapping("/test")
    public boolean test() {
        System.out.println("hello world");
        return true;
    }

    /**
     * 用于获取首页导航栏左侧的标签数据
     *
     * @return
     */
    @RequestMapping("/classes")
    public String[] getLeftNavClasses() {
        String[] classes = {"健康", "你"};
        return classes;
    }


    /**
     * 依据导航标签, 获取首页文章的缩略信息列表
     *
     * @param tag
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/tiny")
    public List<TinyArticleModel> getTinyArticles(@RequestParam String tag,
                                                  @RequestParam Integer page, @RequestParam Integer pageSize) {
        return indexService.getTinyArticles(tag, page, pageSize);
    }

    /**
     * 获取热点文章的列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/hot")
    public List<HotArticleModel> getHotArticles(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return indexService.getHotArticles(page, pageSize);
    }


}
