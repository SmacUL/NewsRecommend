package com.smacul.demo.controller;

import com.smacul.demo.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/self")
public class SelfController {

    @Autowired
    SelfService selfService;

}
