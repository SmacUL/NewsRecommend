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
     * @param comment
     * @return
     */
    Integer addCom(Comment comment);

}
