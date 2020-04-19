package com.smacul.demo.dao;

import com.smacul.demo.model.ArtFullMod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtDao {

    /**
     * 获取文章类别列表并按照数量排序
     * 20-04-18 创建方法
     * @return
     */
    List<String> getArtTypesOrderByTypeNum();

    /**
     * 全局获取一页文章缩略内容, 包括文章基本信息, 文章作者基本信息, 文章的特征统计信息
     * 20-04-19 创建方法
     * @param start
     * @param pageSize
     * @return
     */
    List<ArtFullMod> getTinyArtOnePageFromGlobal(Integer start, Integer pageSize);

    /**
     * 按照类别获取一页文章缩略内容, 包括文章基本信息, 文章作者基本信息, 文章的特征统计信息
     * 20-04-19 创建方法
     * @param type
     * @param start
     * @param pageSize
     * @return
     */
    List<ArtFullMod> getTinyArtOnePageByType(String type, Integer start, Integer pageSize);

    /**
     * 获取一页热点新闻的文章缩略信息, 包括文章基本信息, 文章作者基本信息, 文章的特征统计信息
     * 20-04-19 创建方法
     * @param start
     * @param pageSize
     * @return
     */
    List<ArtFullMod> getHotArtOnePage(Integer start, Integer pageSize);

    /**
     * 获取一篇文章的信息, 包括文章基本信息(包含 content), 文章作者基本信息, 文章的特征统计信息
     * @param artId
     * @return
     */
    ArtFullMod getArtFull(Integer artId);
}
