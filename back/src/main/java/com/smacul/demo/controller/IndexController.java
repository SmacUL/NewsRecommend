package com.smacul.demo.controller;


import com.smacul.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<String> getArticleTags() {
        return indexService.getLeftNavTags();
    }

}
