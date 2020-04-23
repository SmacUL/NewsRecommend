package com.smacul.demo.dao;

import com.smacul.demo.bean.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CusDao {

    /**
     * 通过用户名获取用户基本信息
     * 20-04-18 创建方法
     * 20-04-21 获取内容中添加密码
     * @param cusName
     * @return
     */
    Customer getCusByName(String cusName);

    /**
     * 通过统计用户数判断用户是否存在
     * 20-04-18 创建方法
     * @param cusName
     * @return
     */
    Integer countCusByName(String cusName);

    /**
     * 在用户注册时插入用户
     * 20-04-18 创建方法
     * 20-04-21 参数名修改
     * @param cusName
     * @param cusPass   MD5 加密后的密码
     * @return
     */
    Integer insertCusForRegister(String cusName, String cusPass);

    /**
     * 通过 ID 获取用户基本信息
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    Customer getCusById(Integer cusId);

    /**
     * 更新用户基本信息, 不包括密码.
     * 20-04-18 创建方法
     * @param customer
     * @return
     */
    Integer updateCusBasicInfo(Customer customer);

    /**
     * 更新用户基本信息, 包括密码
     * 20-04-18 创建方法
     * @param customer
     * @return
     */
    Integer updateCusBasicInfoWithPass(Customer customer);
}
