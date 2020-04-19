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

    ///**
    // * 统计指定用户与指定新闻作者之间的关注行为记录.
    // * @param cusId
    // * @param artId
    // * @return
    // */
    //Integer countCusWithArtCusFollowBehavior(Integer cusId, Integer artId);
}
