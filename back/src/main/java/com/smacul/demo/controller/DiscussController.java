package com.smacul.demo.controller;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.CommentCustomerModel;
import com.smacul.demo.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    DiscussService discussService;
    @Autowired
    HttpSession session;

    @RequestMapping("/page")
    public List<CommentCustomerModel> getCommentList(@RequestParam Integer artId) {
        return discussService.getCommentList(artId);
    }

    @RequestMapping("/comment")
    public Boolean cusAddComment(@RequestBody Comment comment) {
        return discussService.cusAddComment(comment);
    }

    @RequestMapping("/reply")
    public Boolean cusAddReply(@RequestBody Reply reply) {
        return discussService.cusAddReply(reply);
    }

    @RequestMapping("/precom")
    public Boolean cusComPreference(@RequestParam Integer comId, @RequestParam Boolean preference) {
        return discussService.cusComPreference(comId, preference);
    }

    @RequestMapping("/prerep")
    public Boolean cusRepPreference(@RequestParam Integer repId, @RequestParam Boolean preference) {
        return discussService.cusRepPreference(repId, preference);
    }
}
