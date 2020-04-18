package com.smacul.demo.controller;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.ComFullMod;
import com.smacul.demo.service.DiscussService;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    DiscussService discussService;
    @Autowired
    ShapeService shapeService;
    @Autowired
    HttpSession session;

    @RequestMapping("/page")
    public List<ComFullMod> getComList(Integer artId) {
        return null;
    }

    @RequestMapping("/com")
    public String addNewCom(@RequestBody Comment comment) {
        return null;
    }

    @RequestMapping("/rep")
    public String addNewRep(@RequestBody Reply reply) {
        return null;
    }

}
