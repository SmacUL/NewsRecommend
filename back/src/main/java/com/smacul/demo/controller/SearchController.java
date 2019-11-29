package com.smacul.demo.controller;


import com.smacul.demo.model.HotArticleModel;
import com.smacul.demo.model.TinyArticleModel;
import com.smacul.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping("/tags")
    public List<String> getLeftNavTags() {
        return searchService.getLeftNavTags();
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
        return searchService.getHotArticles(page, pageSize);
    }

    /**
     * 依据导航标签, 获取搜索页文章的缩略信息列表
     *
     * @param tag
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/tiny")
    public List<TinyArticleModel> getTinyArticles(@RequestParam String tag, @RequestParam String key,
                                                  @RequestParam Integer page, @RequestParam Integer pageSize) {
        return searchService.getTinyArticles(key, tag, page, pageSize);
    }

}
