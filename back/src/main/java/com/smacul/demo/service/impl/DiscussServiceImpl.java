package com.smacul.demo.service.impl;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.ComFullMod;
import com.smacul.demo.service.DiscussService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {

    @Override
    public List<ComFullMod> getComList(Integer artId) {
        return null;
    }

    @Override
    public String addNewCom(Comment comment) {
        return null;
    }

    @Override
    public String addNewRep(Reply reply) {
        return null;
    }
}
