package com.smacul.demo.controller;

import com.smacul.demo.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/port")
public class PortController {

    @Autowired
    PortService portService;

}
