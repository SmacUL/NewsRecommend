package com.smacul.demo.service;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.model.CusDynamicMod;
import com.smacul.demo.model.CusFeatureFullMod;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface SelfService {

    /**
     * 检查用户是否为新用户.
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    Boolean checkIsNewUser(Integer cusId);

    /**
     * 在用户登录时检查用户是否存在, 如果存在, 返回用户基本信息, 否则返回空.
     * 20-04-28 创建方法
     * @param cusName
     * @param cusPass
     * @return
     * @throws NoSuchAlgorithmException
     */
    Customer checkCusForLogin(String cusName, String cusPass) throws NoSuchAlgorithmException;

    /**
     * 在用户注册时插入用户.
     * 20-04-18 创建方法
     * 20-04-23 方法逻辑修改, 在添加用户时, 添加用户的特征统计数据记录.
     * @param cusName
     * @param cusPass
     * @return
     * @throws NoSuchAlgorithmException
     */
    String setNewCus(String cusName, String cusPass) throws NoSuchAlgorithmException;

    /**
     * 获取用户基本数据, 不包括密码
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    Customer getCusBasicInfo(Integer cusId);

    /**
     * 设置用户基本数据, 可包括密码
     * 20-04-18 创建方法
     * @param customer
     * @return
     * @throws NoSuchAlgorithmException
     */
    Boolean setCusBasicInfo(Customer customer) throws NoSuchAlgorithmException;

    /**
     * 处理用户关注, 行为代码: 11
     * 20-04-18 创建方法
     * @param cusIdFrom
     * @param cusIdTo
     * @return
     */
    Boolean setCusFollow(Integer cusIdFrom, Integer cusIdTo);

    /**
     * 获取用户完整的特征数据
     * 20-04-18 创建方法
     * @param cusId
     * @return
     */
    CusFeatureFullMod getCusFeatureInfo(Integer cusId);

    /**
     * 分页获取指定用户的动态
     * 20-04-24 创建方法
     * @param cusId
     * @param page
     * @param pageSize
     * @return
     */
    List<CusDynamicMod> getCusDynamic(Integer cusId, Integer page, Integer pageSize);

}
