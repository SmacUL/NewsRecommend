package com.smacul.demo.service;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.model.CusDynamicMod;
import com.smacul.demo.model.CusFeatureFullMod;

import java.util.List;

public interface SelfService {

    Boolean checkCusIdentify(Customer customer);

    Boolean checkIsNewUser(Customer customer);

    String checkCusForLogin(String cusName, String cusPass);

    String setNewCus(String cusName, String cusPass);

    Customer getCusBasicInfo(Integer cusId);

    Boolean setCusBasicInfo(Customer customer);

    Boolean setCusFollow(Integer cusId);

    CusFeatureFullMod getCusFeatureInfo(Integer cusId);

    List<CusDynamicMod> getCusDynamic(Integer cusId, Integer page, Integer pageSize);

}
