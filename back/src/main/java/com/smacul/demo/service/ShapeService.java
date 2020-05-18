package com.smacul.demo.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

public interface ShapeService {

    /**
     * 文章编辑 1
     * cbrCusIdFrom | cbrCusIdTo | cbrBehavior |   cbrTime   | cbrArtId | cbrType | cbrTargetId
     *    cusId     |    cusId   |       1     |   artTime   |   artId  |    1    |     artId
     * 20-04-19 创建方法
     * @param cusId
     * @param artId
     * @return
     */
    Boolean setCusBehaviorArtEdit(Integer cusId, Integer artId);

    /**
     * 文章阅读 2
     * cbrCusIdFrom | cbrCusIdTo | cbrBehavior |   cbrTime   | cbrArtId | cbrType | cbrTargetId
     *    cusId     |  artCusId  |       2     |   readTime  |   artId  |    1    |     artId
     * 20-04-19 创建方法
     * 20-04-28 修改方法, 防止同一个用户重复阅读
     * @param cusId
     * @param artId
     * @return
     */
    Boolean setCusBehaviorArtRead(Integer cusId, Integer artId);

    /**
     * 文章点赞 3
     * cbrCusIdFrom | cbrCusIdTo | cbrBehavior |   cbrTime   | cbrArtId | cbrType | cbrTargetId
     *    cusId     |  artCusId  |       3     |   likeTime  |   artId  |    1    |     artId
     * 20-04-19 创建方法
     * @param cusId
     * @param artId
     * @param type  true: 点上, false: 取消
     * @return
     */
    Boolean setCusBehaviorArtLike(Integer cusId, Integer artId, Boolean type);

    /**
     * 文章点踩 4
     * cbrCusIdFrom | cbrCusIdTo | cbrBehavior |   cbrTime   | cbrArtId | cbrType | cbrTargetId
     *    cusId     |  artCusId  |       4     | dislikeTime |   artId  |    1    |     artId
     * 20-04-19 创建方法
     * @param cusId
     * @param artId
     * @param type  true: 点上, false: 取消
     * @return
     */
    Boolean setCusBehaviorArtDislike(Integer cusId, Integer artId, Boolean type);

    /**
     * 评论编辑 5
     * cbrCusIdFrom | cbrCusIdTo | cbrBehavior |   cbrTime   | cbrArtId | cbrType | cbrTargetId
     *    cusId     | artCusId   |       5     |   comTime   |   artId  |    2    |     comId
     * @param cusId
     * @param artId
     * @param comId
     * @return
     */
    Boolean setCusBehaviorComEdit(Integer cusId, Integer artId, Integer comId);

    /**
     * 评论点赞 6
     * @param cusId
     * @param comCusId
     * @param artId
     * @param comId
     * @return
     */
    Boolean setCusBehaviorComLike(Integer cusId, Integer comCusId, Integer artId, Integer comId);

    /**
     * 评论点踩 7
     * @param cusId
     * @param comCusId
     * @param artId
     * @param comId
     * @return
     */
    Boolean setCusBehaviorComDislike(Integer cusId, Integer comCusId, Integer artId, Integer comId);

    /**
     * 回复编辑(包括回复与回复的回复) 8
     * cbrCusIdFrom | cbrCusIdTo | cbrBehavior |   cbrTime   | cbrArtId | cbrType | cbrTargetId
     *    cusId     | artCusId   |       8     |   repTime   |   artId  |    3    |     repId
     * 20-04-19 创建方法
     * @param cusId
     * @param artId
     * @param repId
     * @return
     */
    Boolean setCusBehaviorRepEdit(Integer cusId, Integer artId, Integer repId);

    /**
     * 回复点赞 9
     * @param cusId
     * @param repCusId
     * @param artId
     * @param repId
     * @return
     */
    Boolean setCusBehaviorRepLike(Integer cusId, Integer repCusId, Integer artId, Integer repId);

    /**
     * 回复点踩 10
     * @param cusId
     * @param repCusId
     * @param artId
     * @param repId
     * @return
     */
    Boolean setCusBehaviorRepDislike(Integer cusId, Integer repCusId, Integer artId, Integer repId);

    /**
     * 用户 follow 11
     * cbrCusIdFrom | cbrCusIdTo | cbrBehavior |   cbrTime   | cbrArtId | cbrType | cbrTargetId
     *   cusIdFrom  |   cusIdTo  |      11     | followTime  |    null  |    0    |     null
     * 20-04-19 创建方法
     * @param cusIdFrom
     * @param cusIdTo
     * @return
     */
    Boolean setCusBehaviorCusFollow(Integer cusIdFrom, Integer cusIdTo);

}
