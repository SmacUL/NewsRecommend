package com.smacul.demo.dao;

import com.smacul.demo.bean.ArtFeatureCount;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtFeatureCountDao {

    /**
     * 获取文章的特征统计数据
     * 20-04-18 创建方法
     * @param artId
     * @return
     */
    ArtFeatureCount getArtFeatureCountByArtId(Integer artId);

    /**
     * 更新文章指定字段的特征数据
     * 20-04-19 创建方法
     * @param artId
     * @param column    特征字段, 保证 afc 前缀, 下划线
     * @param num
     * @return
     */
    Integer updateArtFeature(Integer artId, String column, Integer num);

}
