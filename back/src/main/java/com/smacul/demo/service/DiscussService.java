package com.smacul.demo.service;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.ComFullMod;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DiscussService {

    /**
     * 获取完整的评论列表
     * 20-04-20 创建方法
     * @param artId
     * @return
     */
    List<ComFullMod> getComList(Integer artId);

    /**
     * 添加评论
     * 20-04-20 创建方法
     * @param comment
     * @return
     */
    String addNewCom(Comment comment);

    /**
     * 添加回复, 包括回复的回复
     * 20-04-20 创建方法
     * @param reply
     * @return
     */
    String addNewRep(Reply reply);

}
