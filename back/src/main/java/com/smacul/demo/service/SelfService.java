package com.smacul.demo.service;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.model.CustomerBehaviorCountModel;
import com.smacul.demo.model.CustomerDynamicModel;


import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface SelfService {

    Customer cusLogin(String cusName, String cusPass) throws NoSuchAlgorithmException;

    Integer cusRegister(String cusName, String cusPass) throws NoSuchAlgorithmException;

    List<CustomerDynamicModel> getCusSelfDynamic(Integer cusId, Integer page, Integer pageSize);

    Customer getCusBasicInfo(Integer cusId);

    CustomerBehaviorCountModel getCusCountInfo(Integer cusId);

    //Customer modifyCusSelfInfo(Customer customer);
}
