package com.smacul.demo.dao;

import com.smacul.demo.bean.Article;
import com.smacul.demo.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesDao {

    List<String> searchArtTypes();

    List<ArticleCustomerModel> searchTinyArtOnePageByType(
            @Param("artType") String artType, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    List<ArticleCustomerModel> searchTinyArtOnePageFromGlobal(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    List<ArticleCustomerModel> searchHotArtOnePage(@Param("start")Integer start, @Param("pageSize")Integer pageSize);

    ArticleCustomerModel searchFullArtWithCus(@Param("artId") Integer artId);

    Boolean updateArtLikeNum(@Param("artId") Integer artId);

    Boolean updateArtDislikeNum(@Param("artId") Integer artId);

    @Deprecated
    List<ArticleCustomerModel> searchContentByKeyAndTagTypePage(
            @Param("key") String key, @Param("type") String type, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    List<ArticleCustomerModel> searchContentAuthor(
            @Param("key") String key, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    List<ArticleCustomerModel> searchContentArticle(
            @Param("key") String key, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    List<ArticleCustomerModel> searchContentGlobal(
            @Param("key") String key, @Param("start") Integer start, @Param("pageSize") Integer pageSize);
}


