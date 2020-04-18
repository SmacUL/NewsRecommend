package com.smacul.demo.controller;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.model.CusDynamicMod;
import com.smacul.demo.model.CusFeatureFullMod;
import com.smacul.demo.service.SearchService;
import com.smacul.demo.service.SelfService;
import com.smacul.demo.service.ShapeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/self")
public class SelfController {

    @Autowired
    SelfService selfService;
    @Autowired
    ShapeService shapeService;
    @Autowired
    HttpSession session;

    @RequestMapping("/login")
    public String cusLogin(String cusName, String cusPass) {
        return null;
    }

    @RequestMapping("/register")
    public String cusRegister(String cusName, String cusPass) {
        return null;
    }

    @RequestMapping("/basic")
    public Customer getCusBasicInfo(Integer cusId) {
        return null;
    }

    @RequestMapping("/modify")
    public String setCusBasicInfo(@RequestBody Customer customer) {
        return null;
    }

    @RequestMapping("/follow")
    public Boolean setCusFollow(Integer cusId) {
        return null;
    }

    @RequestMapping("/feature")
    public CusFeatureFullMod getCusFeatureInfo(Integer cusId) {
        return null;
    }

    @RequestMapping("/dynamic")
    public List<CusDynamicMod> getCusDynamic(Integer cusId, Integer page, Integer pageSize) {
        return null;
    }

}
