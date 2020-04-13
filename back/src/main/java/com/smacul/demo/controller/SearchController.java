package com.smacul.demo.controller;

import com.smacul.demo.model.ArticleCustomerModel;
import com.smacul.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;
    @Autowired
    HttpSession session;

    @RequestMapping("/key")
    public List<ArticleCustomerModel> searchContentByKeyAndTagTypePage(
            @RequestParam String key, @RequestParam String tag, @RequestParam String type,
            @RequestParam Integer page, @RequestParam Integer pageSize) {
        return searchService.searchContentByKeyAndTagTypePage(key, tag, type, page, pageSize);
    }

}
