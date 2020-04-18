package com.smacul.demo.controller;

import com.smacul.demo.service.SearchService;
import com.smacul.demo.service.SelfService;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/self")
public class SelfController {

    @Autowired
    SelfService selfService;
    @Autowired
    ShapeService shapeService;
    @Autowired
    HttpSession session;
}
