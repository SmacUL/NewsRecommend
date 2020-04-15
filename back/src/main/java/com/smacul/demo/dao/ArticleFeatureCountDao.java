package com.smacul.demo.dao;

import com.smacul.demo.bean.ArticleFeatureCount;
import com.smacul.demo.model.CustomerDynamicModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleFeatureCountDao {

    ArticleFeatureCount searchFeatureCountByArtId(@Param("artId") Integer artId);

}
