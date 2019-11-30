package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.CustomersMapper;
import com.smacul.demo.model.CustomerModel;
import com.smacul.demo.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SelfServiceImpl implements SelfService {

    @Autowired
    CustomersMapper customersMapper;

    @Autowired
    HttpSession session;

    @Override
    public CustomerModel getCustomerInfoByArtId(Integer artId) {
        return customersMapper.getCustomerInfoByArtId(artId);
    }

    @Override
    public CustomerModel getCustomerInfoByCusId(Integer cusId) {
        return customersMapper.getCustomerInfoByCusId(cusId);
    }
}
