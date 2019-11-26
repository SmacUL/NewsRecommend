package com.smacul.demo.controller;


import com.smacul.demo.model.TinyArticle;
import com.smacul.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */
    @RequestMapping("/tags")
    public List<String> getLeftNavTags() {
        return indexService.getLeftNavTags();
    }

    @RequestMapping("/tiny")
    public List<TinyArticle> getTinyArticles(@RequestParam String tag,
                                             @RequestParam Integer page, @RequestParam Integer pageSize) {
        System.out.println(tag);
        return indexService.getTinyArticles(tag, page, pageSize);
    }

}
