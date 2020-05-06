package com.smacul.demo.dao;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.model.ComFullMod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComDao {

    /**
     * 获取评论列表
     * 20-04-20 创建方法
     * @param artId
     * @return
     */
    List<ComFullMod> getComFullList(Integer artId);

    /**
     * 添加评论
     * 20-04-10 创建方法
     * 20-04-24 允许评论后返回自增主键
     * @param comment
     * @return
     */
    Integer addCom(Comment comment);

    /**
     * 获取单一一条评论, 不包括其回复
     * 20-04-24 创建方法
     * @param flag      用来判断是否需要查询, 生效值为 2
     * @param comId
     * @return
     */
    ComFullMod getSingleCom(Integer flag, Integer comId);

}
