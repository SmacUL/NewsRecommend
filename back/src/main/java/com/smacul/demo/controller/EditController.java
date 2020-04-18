package com.smacul.demo.controller;

import com.smacul.demo.service.EditService;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
