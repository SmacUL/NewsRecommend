package com.smacul.demo.controller;

import com.smacul.demo.bean.Article;
import com.smacul.demo.bean.Customer;
import com.smacul.demo.service.EditService;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/edit")
public class EditController {

    @Autowired
    EditService editService;
    @Autowired
    ShapeService shapeService;
    @Autowired
    HttpSession session;

    /**
     * 用户添加新的文章
     * 20-05-04 添加方法
     * @param article
     * @return
     */
    @RequestMapping("/add")
    public Integer addNewArt(@RequestBody Article article) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return 0;
        }

        String result = editService.addNewArt(article);
        if (result.equals("文章添加成功")) {
            shapeService.setCusBehaviorArtEdit(customer.getCusId(), article.getArtId());
        }
        return article.getArtId();
    }

}
