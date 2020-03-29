package com.smacul.demo.controller;


import com.oracle.tools.packager.Log;
import com.smacul.demo.bean.Article;
import com.smacul.demo.model.ArticleCustomerModel;
import com.smacul.demo.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    LoadService loadService;
    @Autowired
    HttpSession session;

    /**
     * 获取所有的文章类别
     * localhost:8080/load/type
     *
     * @return
     */
    @RequestMapping("/type")
    public List<String> getArtTypes() {
        return loadService.getArtTypes();
    }

    /**
     * 按照类别获取一页数量的文章.
     * localhost:8080/load/tiny?artType=news_global&page=0&pageSize=10
     * localhost:8080/load/tiny?artType=news_car&page=0&pageSize=10
     *
     * @param artType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/tiny")
    public List<ArticleCustomerModel> getTinyArtOnePageByClass (
            @RequestParam String artType, @RequestParam Integer page, @RequestParam Integer pageSize) {
        return loadService.getTinyArtOnePageByType(artType, page, pageSize);
    }

    /**
     * 获取一页热点内容
     * localhost:8080/load/hot?page=0&pageSize=6
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/hot")
    public List<ArticleCustomerModel> getHotArtOnePage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return loadService.getHotArtOnePage(page, pageSize);
    }

    /**
     * 获取文章的主要内容, 包括作者的基本信息
     * localhost:8080/load/main?artId=1
     *
     * @param artId
     * @return
     */
    @RequestMapping("/main")
    public ArticleCustomerModel getFullArtWithCus(@RequestParam Integer artId) {
        return loadService.getFullArtWithCus(artId);
    }

    /**
     * 用户点赞或点踩文章时触发此方法
     *
     *
     * @param artId
     * @param preference
     * @return
     */
    @RequestMapping("/prefer")
    public Boolean cusArtPreference(Integer artId, Boolean preference) {
        return loadService.cusArtPreference(artId, preference);
    }

}
