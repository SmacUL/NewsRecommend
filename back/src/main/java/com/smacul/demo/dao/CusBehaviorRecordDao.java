package com.smacul.demo.dao;

import com.smacul.demo.bean.CusBehaviorRecord;
import com.smacul.demo.model.CusDynamicMod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CusBehaviorRecordDao {

    /**
     * 统计指定两个用户之间关注行为记录的数量
     * 20-04-18 添加方法
     * @param cusIdFrom
     * @param cusIdTo
     * @return
     */
    Integer countTargetCusFollowBehavior(Integer cusIdFrom, Integer cusIdTo);

    /**
     * 删除指定两个用户之间的关注行为记录
     * 20-04-18 添加方法
     * @param cusIdFrom
     * @param cusIdTo
     * @return
     */
    Integer deleteTargetCusFollowBehavior(Integer cusIdFrom, Integer cusIdTo);

    /**
     * 添加指定两个用户之间的关注行为记录
     * 20-04-18 添加方法
     * @param cusIdFrom
     * @param cusIdTo
     * @return
     */
    Integer addTargetCusFollowBehavior(Integer cusIdFrom, Integer cusIdTo);

    /**
     * 统计指定 from 用户指定行为的记录数量
     * 20-04-18 添加方法
     * @param cusIdFrom
     * @param behavior
     * @return
     */
    Integer countCusBehaviorFrom(Integer cusIdFrom, Integer behavior);

    /**
     * 统计指定 to 用户指定行为的记录数量
     * 20-04-18 添加方法
     * @param cusIdTo
     * @param behavior
     * @return
     */
    Integer countCusBehaviorTo(Integer cusIdTo, Integer behavior);

    /**
     * 统计指定 from 用户与指定文章之间指定行为的记录数量
     * 20-04-19 创建方法
     * 20-04-23 BUG 修复 SQL 参数错误
     * @param cusIdFrom
     * @param artId
     * @param behavior
     * @return
     */
    Integer countTargetCusArtBehaviorFrom(Integer cusIdFrom, Integer artId, Integer behavior);

    /**
     * 统计指定 to 用户与指定文章之间指定行为的记录数量
     * 20-04-19 成绩方法
     * 20-04-23 BUG 修复 SQL 参数错误
     * @param cusIdTo
     * @param artId
     * @param behavior
     * @return
     */
    Integer countTargetCusArtBehaviorTo(Integer cusIdTo, Integer artId, Integer behavior);

    /**
     * 插入用户行为记录
     * 本质上, 这个方法可以取代 addTargetCusFollowBehavior
     * 20-04-19 创建方法
     * @param cusIdFrom
     * @param cusIdTo
     * @param behavior
     * @param artId
     * @param type
     * @param targetId
     * @return
     */
    Integer addCusBehavior(
            Integer cusIdFrom, Integer cusIdTo, Integer behavior, Integer artId, Integer type, Integer targetId);

    /**
     * 删除用户行为记录
     * 本质上, 这个方法可以取代 deleteTargetCusFollowBehavior
     * 20-04-19 创建方法
     * @param cusIdFrom
     * @param cusIdTo
     * @param behavior
     * @param artId
     * @param type
     * @param targetId
     * @return
     */
    Integer deleteCusBehavior(
            Integer cusIdFrom, Integer cusIdTo, Integer behavior, Integer artId, Integer type, Integer targetId);

    /**
     * 分页获取指定用户动态
     * 20-04-24 创建方法
     * 20-05-06 修改排序时间
     * @param cusId
     * @param start
     * @param pageSize
     * @return
     */
    List<CusDynamicMod> getCusDynamicByCusId(Integer cusId, Integer start, Integer pageSize);


    /**
     * 获取指定用户所有的关注用户的列表
     * 20-05-02 创建方法
     * @param cusId
     * @return
     */
    List<Integer> getFollowCus(Integer cusId);
}
