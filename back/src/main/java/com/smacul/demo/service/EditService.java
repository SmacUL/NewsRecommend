package com.smacul.demo.service;

import com.smacul.demo.bean.Article;

public interface EditService {

    /**
     * 用户添加新文章
     * 20-05-04 创建方法
     * 20-05-11 方法修改, 添加 artLegal
     * @param article
     * @return
     */
    String addNewArt(Article article);

}
