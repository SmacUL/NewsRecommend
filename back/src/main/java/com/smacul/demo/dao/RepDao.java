package com.smacul.demo.dao;

import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.RepFullMod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepDao {

    /**
     * 通过评论 ID 来获取此评论下所有的回复
     * 20-04-19 创建方法
     * 20-04-23 BUG 修复, SQL 逗号问题
     * @param comId
     * @return
     */
    List<RepFullMod> getRepFullList(Integer comId);

    /**
     * 添加回复
     * 20-04-19 创建方法
     * @param reply
     * @return
     */
    Integer addRep(Reply reply);

}
