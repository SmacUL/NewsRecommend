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
     * 20-04-26 修改方法, 只有当用户关注关系创建时, 才返回 true.
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
     * 20-05-06 修改方法, 用户动态如果有文章, 则将文章的类别由英文改为中文
     * @param cusId
     * @param page
     * @param pageSize
     * @return
     */
    List<CusDynamicMod> getCusDynamic(Integer cusId, Integer page, Integer pageSize);

    /**
     * 检查用户之间是否存在关注关系
     * 20-04-26 创建方法
     * @param cusIdFrom
     * @param cusIdTo
     * @return
     */
    Boolean checkCusFollow(Integer cusIdFrom, Integer cusIdTo);

    /**
     * 获取指定用户的相似用户
     * 如果用户是新用户则不计算相似用户, 直接返回空的 ArrayList;
     * 如果用户是老用户, 优先考虑他关注的用户, 再计算相似用户.
     * 返回 10 个吧先
     * 20-05-02 创建方法
     * @param cusId
     * @param num
     * @return
     */
    List<Integer> getRelativeCusList(Integer cusId, Integer num);
}
