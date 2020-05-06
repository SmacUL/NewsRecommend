package com.smacul.demo.controller;

import com.smacul.demo.bean.Comment;
import com.smacul.demo.bean.Customer;
import com.smacul.demo.bean.Reply;
import com.smacul.demo.model.ComFullMod;
import com.smacul.demo.service.DiscussService;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    ShapeService shapeService;
    @Autowired
    HttpSession session;

    /**
     * 获取完整的评论列表
     * 20-04-20 方法创建
     * @param artId
     * @return
     */
    @RequestMapping("/page")
    public List<ComFullMod> getComList(@RequestParam Integer artId) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return null;
        }
        return discussService.getComList(artId);
    }

    /**
     * 添加评论
     * 20-04-20 添加方法
     * 20-05-04 在插入用户行为数据之前, 对 result 的内容进行检查
     * @param comment
     * @return
     */
    @RequestMapping("/com")
    public String addNewCom(@RequestBody Comment comment) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "评论失败";
        }
        String result = discussService.addNewCom(comment);
        if (result.equals("评论成功")) {
            shapeService.setCusBehaviorComEdit(customer.getCusId(), comment.getComArtId(), comment.getComId());
        }
        return result;
    }

    /**
     * 添加回复
     * 20-04-20 添加方法
     * 20-05-04 在插入用户行为数据之前, 对 result 的内容进行检查
     * @param reply
     * @return
     */
    @RequestMapping("/rep")
    public String addNewRep(@RequestBody Reply reply) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "评论失败";
        }
        String result = discussService.addNewRep(reply);
        if (result.equals("评论成功")) {
            shapeService.setCusBehaviorRepEdit(customer.getCusId(), reply.getRepArtId(), reply.getRepId());
        }
        return result;
    }

}
