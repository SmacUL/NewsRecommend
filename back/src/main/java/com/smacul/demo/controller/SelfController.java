package com.smacul.demo.controller;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.dao.CusDao;
import com.smacul.demo.model.CusDynamicMod;
import com.smacul.demo.model.CusFeatureFullMod;
import com.smacul.demo.service.SearchService;
import com.smacul.demo.service.SelfService;
import com.smacul.demo.service.ShapeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
    ShapeService shapeService;
    @Autowired
    HttpSession session;

    /**
     * 用户登录
     * 20-04-18 创建方法
     * @param cusName
     * @param cusPass
     * @return
     */
    @RequestMapping("/login")
    public String cusLogin(@RequestParam String cusName, @RequestParam String cusPass) {
        if (session.getAttribute("customer") != null) {
            return "您已登录";
        }
        try {
            Customer customer = selfService.checkCusForLogin(cusName, cusPass);
            if (customer != null) {
                customer.setCusPass(null);
                session.setAttribute("customer", customer);
                return "登录成功";
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return "登录失败";
    }

    /**
     * 用户退出登录
     * 20-04-24 创建方法
     * @return
     */
    @RequestMapping("/quit")
    public String quitLogin() {
        session.setAttribute("customer", null);
        return "退出成功";
    }

    /**
     * 用户注册
     * 20-04-18 创建方法
     * 20-04-24 逻辑修改, 在注册时清空 session 中的用户
     * @param cusName
     * @param cusPass
     * @return
     */
    @RequestMapping("/register")
    public String cusRegister(@RequestParam String cusName, @RequestParam String cusPass) {
        try {
            session.setAttribute("customer", null);
            return selfService.setNewCus(cusName, cusPass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "注册失败";
    }

    /**
     * 通过 ID 获取用户基本信息
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    @RequestMapping("/basic")
    public Customer getCusBasicInfo(@RequestParam Integer cusId) {
        if (session.getAttribute("customer") == null) {
            return null;
        }
        if (cusId == null || cusId <= 0) {
            return (Customer) session.getAttribute("customer");
        } else {
            return selfService.getCusBasicInfo(cusId);
        }
    }

    /**
     * 修改用户的基本信息
     * 20-04-18 创建方法
     * @param customer
     * @return
     */
    @RequestMapping("/modify")
    public String setCusBasicInfo(@RequestBody Customer customer) {
        if (session.getAttribute("customer") == null) {
            return "修改失败";
        }
        try {
            if (selfService.setCusBasicInfo(customer)) {
                session.setAttribute("customer", customer);
                return "修改成功";
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "修改失败";
    }

    /**
     * 处理用户关注与取消关注
     * 20-04-18 创建方法
     * 20-04-26 修改逻辑, 防止用户关注自己
     * @param cusId 关注或取消关注的用户的 ID
     * @return
     */
    @RequestMapping("/follow")
    public String setCusFollow(@RequestParam Integer cusId) {
        if (session.getAttribute("customer") == null) {
            return "关注失败";
        }
        Customer cusFrom = (Customer) session.getAttribute("customer");
        Integer cusIdFrom = cusFrom.getCusId();
        if (cusId.equals(cusIdFrom)) {
            return "不能关注自己";
        }
        if (selfService.setCusFollow(cusIdFrom, cusId)) {
            return "关注成功";
        } else {
            return "关注失败";
        }
    }

    /**
     * 获取用户完成的特征数据
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    @RequestMapping("/feature")
    public CusFeatureFullMod getCusFeatureInfo(@RequestParam Integer cusId) {
        return selfService.getCusFeatureInfo(cusId);
    }

    /**
     * 获取指定用户的动态
     * 20-04-24 创建方法
     * @param cusId
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/dynamic")
    public List<CusDynamicMod> getCusDynamic(
            @RequestParam Integer cusId, @RequestParam Integer page, @RequestParam Integer pageSize) {
        if (session.getAttribute("customer") == null) {
            return null;
        }
        return selfService.getCusDynamic(cusId, page, pageSize);
    }

    /**
     * 检查用户之间是否存在关注关系
     * 20-04-26 创建方法
     * @param cusId
     * @return
     */
    @RequestMapping("/chefollow")
    public Boolean checkCusFollow(@RequestParam Integer cusId) {
        Customer cusFrom = (Customer) session.getAttribute("customer");
        if (cusFrom == null) {
            return false;
        }
        return selfService.checkCusFollow(cusFrom.getCusId(), cusId);
    }

}
