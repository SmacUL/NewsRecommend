package com.smacul.demo.controller;

import com.smacul.demo.model.ArtFullMod;
import com.smacul.demo.service.SearchService;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;
    @Autowired
    ShapeService shapeService;
    @Autowired
    HttpSession session;

    @RequestMapping("/simple")
    public List<ArtFullMod> searchContentSimple(String key, Integer page, Integer pageSize) {
        return null;
    }
}
