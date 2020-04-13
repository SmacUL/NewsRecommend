package com.smacul.demo.dao;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Customer;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.CommentCustomerModel;
import com.smacul.demo.model.ReplyCustomerModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsDao {
    List<CommentCustomerModel> searchCommentList(@Param("artId") Integer artId);

    Integer insertComment(Comment comment);

    Integer updateComLikeNum(@Param("comId") Integer comId);

    Integer updateComDislikeNum(@Param("comId") Integer comId);

}
