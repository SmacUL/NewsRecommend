package com.smacul.demo.controller;

import com.smacul.demo.service.LoadService;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    LoadService loadService;
    @Autowired
    ShapeService shapeService;
    @Autowired
    HttpSession session;
}
