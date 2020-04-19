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
}
