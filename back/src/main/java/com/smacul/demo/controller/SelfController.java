package com.smacul.demo.controller;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.model.CustomerBehaviorCountModel;
import com.smacul.demo.model.CustomerDynamicModel;
import com.smacul.demo.service.SelfService;
import com.sun.tools.corba.se.idl.InterfaceGen;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/self")
public class SelfController {

    @Autowired
    SelfService selfService;
    @Autowired
    HttpSession session;

    /**
     * 用户登录
     * localhost:8080/self/login?cusName=山东艾珍珍1&cusPass=123456
     *
     * @param cusName
     * @param cusPass
     * @return
     */
    @RequestMapping("/login")
    public Boolean cusLogin(@RequestParam String cusName, @RequestParam String cusPass) {
        try {
            Customer customer = selfService.cusLogin(cusName, cusPass);
            if (customer != null) {
                customer.setCusPass("");
                session.setAttribute("customer", customer);
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return false;
    }

    /**
     * 用户注册
     *
     * 0: md5 异常, 1: 处理成功, 2: 插入失败, 3: 用户名已经存在
     *
     * @param cusName
     * @param cusPass
     * @return
     */
    @RequestMapping("/register")
    public Integer cusRegister(@RequestParam String cusName, @RequestParam String cusPass) {
        try {
            return selfService.cusRegister(cusName, cusPass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return 0;
    }

    /**
     * 获取用户自己的信息
     *
     * 前提是用户已经登录
     *
     * @return
     */
    @RequestMapping("/own")
    public Customer getCusSelfInfo() {
        return (Customer) session.getAttribute("customer");
    }

    //public Customer modifyCusSelfInfo(@RequestBody Customer customer) {
    //    return selfService.modifyCusSelfInfo(customer);
    //}

    @RequestMapping("/basic")
    public Customer getCusBasicInfo(@RequestParam Integer cusId) {
        return selfService.getCusBasicInfo(cusId);
    }

    @RequestMapping("/count")
    public CustomerBehaviorCountModel getCusCountInfo(@RequestParam Integer cusId) {
        return selfService.getCusCountInfo(cusId);
    }

    /**
     *
     * @param cusId 这个用户指用户中心归属的用户
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/dynamic")
    public List<CustomerDynamicModel> getCusSelfDynamic(
            @RequestParam Integer cusId, @RequestParam Integer page, @RequestParam Integer pageSize) {
        return selfService.getCusSelfDynamic(cusId, page, pageSize);
    }



}
