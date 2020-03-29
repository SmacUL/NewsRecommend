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

    ArticleCustomerModel searchFullArtWithCus(Integer artId);

    Boolean updateArtLikeNum(Integer artId);

    Boolean updateArtDislikeNum(Integer artId);
}


