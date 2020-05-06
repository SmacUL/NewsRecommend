package com.smacul.demo.service.impl;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.dao.ComDao;
import com.smacul.demo.dao.RepDao;
import com.smacul.demo.model.ComFullMod;
import com.smacul.demo.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    ComDao comDao;
    @Autowired
    RepDao repDao;

    @Override
    public List<ComFullMod> getComList(Integer artId) {
        return comDao.getComFullList(artId);
    }

    @Override
    public String addNewCom(Comment comment) {
        if (comDao.addCom(comment) == 1) {
            return "评论成功";
        } else {
            return "评论失败";
        }
    }

    @Override
    public String addNewRep(Reply reply) {
        if (repDao.addRep(reply) == 1) {
            return "评论成功";
        } else {
            return "评论失败";
        }
    }
}
