package com.smacul.demo.service;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.ComFullMod;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DiscussService {

    List<ComFullMod> getComList(Integer artId);

    String addNewCom(Comment comment);

    String addNewRep(Reply reply);

}
