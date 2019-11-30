package com.smacul.demo.controller;

import com.smacul.demo.model.CustomerModel;
import com.smacul.demo.model.TinyArticleModel;
import com.smacul.demo.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/self")
public class SelfController {

    @Autowired
    SelfService selfService;

    @RequestMapping("/art")
    public CustomerModel getCustomerInfoByArtId(@RequestParam Integer id) {
        return selfService.getCustomerInfoByArtId(id);
    }

    @RequestMapping("/cus")
    public CustomerModel getCustomerInfoByCusId(@RequestParam Integer id) {
        return selfService.getCustomerInfoByCusId(id);
    }

    @RequestMapping("/tiny")
    public List<TinyArticleModel> getCustomerArticles(@RequestParam Integer cusId,
                                                      @RequestParam Integer page, @RequestParam Integer pageSize) {
        return selfService.getCustomerArticles(cusId, page, pageSize);
    }

}
