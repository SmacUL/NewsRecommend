package com.smacul.demo.controller;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.model.ArtFullMod;
import com.smacul.demo.service.LoadService;
import com.smacul.demo.service.SelfService;
import com.smacul.demo.service.ShapeService;
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
    ShapeService shapeService;
    @Autowired
    SelfService selfService;
    @Autowired
    HttpSession session;

    /**
     * 获取新闻类别(英文)
     * 20-04-19 创建方法 TODO 老用户的处理逻辑还没完成
     * @return
     */
    @RequestMapping("/type")
    public List<String> getArtTypes() {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return null;
        }
        if (selfService.checkIsNewUser(customer.getCusId())) {
            return loadService.getArtTypesForNew();
        } else {
            return loadService.getArtTypesForOld(customer.getCusId());
        }
    }

    /**
     * 按照类别获取一页文章
     * 20-04-19 创建方法
     * 20-05-02 添加老用户推荐逻辑
     * @param artType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/tiny")
    public List<ArtFullMod> getTinyArtOnePageByType(
            @RequestParam String artType, @RequestParam Integer page, @RequestParam Integer pageSize) {
        Customer customer = (Customer) session.getAttribute("customer");
        List<Integer> relativeCusList = (List<Integer>) session.getAttribute("relative");
        if (customer == null || relativeCusList == null) {
            return null;
        }
        if (selfService.checkIsNewUser(customer.getCusId())) {
            return loadService.getTinyArtOnePageByTypeForNew(customer.getCusId(), artType, page, pageSize);
        } else {
            return loadService.getTinyArtOnePageByTypeForOld(customer.getCusId(), relativeCusList, artType, page, pageSize);
        }
    }

    /**
     * 提供一页的热点新闻
     * 20-04-19 创建方法
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/hot")
    public List<ArtFullMod> getHotArtOnePage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return null;
        }
        return loadService.getHotArtOnePage(page, pageSize);
    }

    /**
     * 获取文章的主体内容, 包括文章内容, 文章作者, 文章的特征信息, 当前用户与文章的关系.
     * 20-04-19 创建方法
     * @param artId
     * @return
     */
    @RequestMapping("/main")
    public ArtFullMod getFullArt(@RequestParam Integer artId) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return null;
        }
        ArtFullMod artFullMod = loadService.getFullArt(customer.getCusId(), artId);
        shapeService.setCusBehaviorArtRead(customer.getCusId(), artId);
        return artFullMod;
    }

    /**
     * 文章点赞/点踩控制, 包括取消
     * 20-04-19 创建方法
     * @param artId
     * @param type  1: 点赞, 2: 点踩, -1: 取消点赞, -2: 取消点踩
     * @return
     */
    @RequestMapping("/prefer")
    public String setArtPreference(@RequestParam Integer artId, @RequestParam Integer type) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "操作失败";
        }
        Boolean result = false;
        switch (type){
            case 1:
                result = shapeService.setCusBehaviorArtLike(customer.getCusId(), artId, true);
                break;
            case 2:
                result = shapeService.setCusBehaviorArtDislike(customer.getCusId(), artId, true);
                break;
            case -1:
                result = shapeService.setCusBehaviorArtLike(customer.getCusId(), artId, false);
                break;
            case -2:
                result = shapeService.setCusBehaviorArtDislike(customer.getCusId(), artId, false);
                break;
        }
        if (result) {
            return "操作成功";
        } else {
            return "操作失败";
        }
    }

}
