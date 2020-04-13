package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.dao.CommentsDao;
import com.smacul.demo.dao.ReplysDao;
import com.smacul.demo.model.CommentCustomerModel;
import com.smacul.demo.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    CommentsDao commentsDao;
    @Autowired
    ReplysDao replysDao;

    @Override
    public List<CommentCustomerModel> getCommentList(Integer artId) {
        return commentsDao.searchCommentList(artId);
    }

    @Override
    public Boolean cusAddComment(Comment comment) {
        // todo 在没有管理员的情况下, 默认为合法 1
        comment.setComLegal(1);
        if (commentsDao.insertComment(comment) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean cusAddReply(Reply reply) {
        // todo 在没有管理员的情况下, 默认为合法 1
        reply.setRepLegal(1);
        //return replysDao.insertReply(reply);
        if (replysDao.insertReply(reply) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean cusComPreference(Integer comId, Boolean preference) {
        //return commentsDao.updateComPreference(preference);
        Integer result = 0;
        if (preference) {
            result = commentsDao.updateComLikeNum(comId);
        } else {
            result = commentsDao.updateComDislikeNum(comId);
        }
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean cusRepPreference(Integer repId, Boolean preference) {
        Integer result = 0;
        if (preference) {
            result = replysDao.updateRepLikeNum(repId);
        } else {
            result = replysDao.updateRepDislikeNum(repId);
        }

        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}
