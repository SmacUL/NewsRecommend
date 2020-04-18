package com.smacul.demo.controller;

import com.smacul.demo.model.ArtFullMod;
import com.smacul.demo.service.LoadService;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    LoadService loadService;
    @Autowired
    ShapeService shapeService;
    @Autowired
    HttpSession session;

    /**
     * 获取新闻类别(英文)
     *
     * @return
     */
    @RequestMapping("/type")
    public List<String> getArtTypes() {
        return null;
    }

    /**
     * 按照类别获取一页文章,
     *
     * todo 包含推荐逻辑
     *
     * @param artType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/tiny")
    public List<ArtFullMod> getTinyArtOnePageByType(String artType, Integer page, Integer pageSize) {
        return null;
    }

    /**
     * 提供一页的热点新闻
     *
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/hot")
    public List<ArtFullMod> getHotArtOnePage(Integer page, Integer pageSize) {
        return null;
    }

    /**
     * 获取文章的主体内容, 包括文章内容与文章作者, 文章的特征以及当前用户与文章的关系.
     *
     * @param artId
     * @return
     */
    @RequestMapping("/main")
    public ArtFullMod getFullArt(Integer artId) {
        return null;
    }

    /**
     * 文章点赞/点踩控制, 包括取消
     *
     * @param artId
     * @param type  1: 点赞, 2: 点踩, -1: 取消点赞, -2: 取消点踩
     * @return
     */
    @RequestMapping("/prefer")
    public String setArtPreference(Integer artId, Integer type) {
        return null;
    }

}
