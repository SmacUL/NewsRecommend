package com.smacul.demo.service;

import com.smacul.demo.model.ArtFullMod;

import java.util.List;

public interface SearchService {

    /**
     * 简单的搜索 % %
     * 20-04-20 创建方法
     * 20-05-06
     * @param key
     * @param page
     * @param pageSize
     * @return
     */
    List<ArtFullMod> searchContentSimple(String key, Integer page, Integer pageSize);

}
