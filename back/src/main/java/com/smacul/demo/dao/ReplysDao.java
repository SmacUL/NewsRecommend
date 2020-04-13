package com.smacul.demo.dao;

import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.ReplyCustomerModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplysDao {

    List<ReplyCustomerModel> searchReplysByComId(@Param("comId") Integer comId);

    Integer insertReply(Reply reply);

    Integer updateRepLikeNum(@Param("repId") Integer repId);

    Integer updateRepDislikeNum(@Param("repId") Integer repId);
}
