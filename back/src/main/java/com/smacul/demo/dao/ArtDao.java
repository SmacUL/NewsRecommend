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
     * 20-04-23 BUG 修改, SQL 多了一个逗号
     * 20-04-24 方法修改, 替换了排序方式
     * @param start
     * @param pageSize
     * @return
     */
    List<ArtFullMod> getTinyArtOnePageFromGlobal(Integer start, Integer pageSize);

    /**
     * 按照类别获取一页文章缩略内容, 包括文章基本信息, 文章作者基本信息, 文章的特征统计信息
     * 20-04-19 创建方法
     * 20-04-23 BUG 修改, SQL 多了一个逗号; 参数 type 修改为 artType
     * 20-04-24 方法修改, 替换了排序方式
     * @param artType
     * @param start
     * @param pageSize
     * @return
     */
    List<ArtFullMod> getTinyArtOnePageByType(String artType, Integer start, Integer pageSize);

    /**
     * 获取一页热点新闻的文章缩略信息, 包括文章基本信息, 文章作者基本信息, 文章的特征统计信息
     * 20-04-19 创建方法
     * 20-04-23 BUG 修改, SQL 多了一个逗号
     * 20-04-24 方法修改, 替换了排序方式
     * @param start
     * @param pageSize
     * @return
     */
    List<ArtFullMod> getHotArtOnePage(Integer start, Integer pageSize);

    /**
     * 获取一篇文章的信息, 包括文章基本信息(包含 content), 文章作者基本信息, 文章的特征统计信息
     * 20-04-19 创建方法
     * @param artId
     * @return
     */
    ArtFullMod getArtFull(Integer artId);

    /**
     * 通过文章 ID 获取文章作者的 ID
     * 20-04-19 创建方法
     * @param artId
     * @return
     */
    Integer getArtCusIdByArtId(Integer artId);

    /**
     * 通过文章 ID 获取文章类别
     * 20-04-19 创建方法
     * @param artId
     * @return
     */
    String getArtTypeByArtId(Integer artId);

    /**
     * 简单的搜索功能
     * 20-04-20 创建方法
     * 20-04-23 BUG 修改, SQL 多了一个逗号; 删除了 SQL 中不必要的字段.
     * 20-04-24 方法修改, 替换了排序方式
     * @param key
     * @param start
     * @param pageSize
     * @return
     */
    List<ArtFullMod> searchContentSimple(String key, Integer start, Integer pageSize);

    /**
     * 返回一篇文章的基本信息
     * 20-04-24 创建方法
     * @param flag      用来判断此查询是否要生效, 生效值 非 11.
     * @param artId
     * @return
     */
    ArtFullMod getSingleArt(Integer flag, Integer artId);
}
