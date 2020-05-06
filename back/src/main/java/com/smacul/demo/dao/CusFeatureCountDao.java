package com.smacul.demo.dao;

import com.smacul.demo.bean.CusFeatureCount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CusFeatureCountDao {

    /**
     * 获取指定 ID 用户在所有类别下的操作次数总和
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    Integer countBehaviorNum(Integer cusId);

    /**
     * 获取指定 ID 用户的类别统计数据.
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    CusFeatureCount getCusFeatureCountByCusId(Integer cusId);

    /**
     * 获取指定 ID 用户的类别统计数据(仅 18 个类别的数据)以及所有类别数据总和
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    List<Integer> getCusArtTypesBehaviorNums(Integer cusId);

    /**
     * 更新用户特征
     * 20-04-19 创建方法
     * @param cusId
     * @param column    字段名, 先保证 cfc 前缀, 下划线
     * @param num
     * @return
     */
    Integer updateCusFeature(Integer cusId, String column, Integer num);

    /**
     * 初始化指定用户的特征数据记录, 即所有种类统计归 0
     * 20-04-23 创建方法
     * @param cusId
     * @return
     */
    Integer initialCusFeature(Integer cusId);

    /**
     * 获取用户的相似用户
     * 20-05-02 创建方法
     * @param cusId
     * @param num
     * @return
     */
    List<Integer> getRelativeCusList(Integer cusId, Integer num);
}
