package com.smacul.demo.service;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.CommentCustomerModel;

import java.util.List;

public interface DiscussService {

    List<CommentCustomerModel> getCommentList(Integer artId);

    Boolean cusAddComment(Comment comment);

    Boolean cusAddReply(Reply reply);

    Boolean cusComPreference(Integer comId, Boolean preference);

    Boolean cusRepPreference(Integer repId, Boolean preference);
}
