package com.smacul.demo.dao;

import com.smacul.demo.bean.CusBehaviorRecord;
import org.springframework.stereotype.Repository;

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
     * 统计指定 to 用户与指定文章之间指定行为的记录数量
     * 20-04-19 创建方法
     * @param cusIdFrom
     * @param artId
     * @param behavior
     * @return
     */
    Integer countTargetCusArtBehaviorFrom(Integer cusIdFrom, Integer artId, Integer behavior);

    /**
     * 统计指定 from 用户与指定文章之间指定行为的记录数量
     * @param cusIdFrom
     * @param artId
     * @param behavior
     * @return
     */
    Integer countTargetCusArtBehaviorTo(Integer cusIdFrom, Integer artId, Integer behavior);

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

    CusBehaviorRecord getCusBehaviorRecordByCusId(Integer cusId);

}
