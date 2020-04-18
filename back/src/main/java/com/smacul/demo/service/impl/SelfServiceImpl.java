package com.smacul.demo.service.impl;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.model.CusDynamicMod;
import com.smacul.demo.model.CusFeatureFullMod;
import com.smacul.demo.service.SelfService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfServiceImpl implements SelfService {

    @Override
    public Boolean checkCusIdentify(Customer customer) {
        return null;
    }

    @Override
    public Boolean checkIsNewUser(Customer customer) {
        return null;
    }

    @Override
    public String checkCusForLogin(String cusName, String cusPass) {
        return null;
    }

    @Override
    public String setNewCus(String cusName, String cusPass) {
        return null;
    }

    @Override
    public Customer getCusBasicInfo(Integer cusId) {
        return null;
    }

    @Override
    public Boolean setCusBasicInfo(Customer customer) {
        return null;
    }

    @Override
    public Boolean setCusFollow(Integer cusId) {
        return null;
    }

    @Override
    public CusFeatureFullMod getCusFeatureInfo(Integer cusId) {
        return null;
    }

    @Override
    public List<CusDynamicMod> getCusDynamic(Integer cusId, Integer page, Integer pageSize) {
        return null;
    }
}
