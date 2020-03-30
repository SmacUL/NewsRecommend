package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.dao.CustomersDao;
import com.smacul.demo.service.SelfService;
import com.smacul.demo.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class SelfServiceImpl implements SelfService {

    @Autowired
    CustomersDao customersDao;

    @Override
    public Customer cusLogin(String cusName, String cusPass) throws NoSuchAlgorithmException {
        String cryptString = MD5.MD5Creator(cusPass);
        Customer customer = customersDao.searchCusByName(cusName);
        if (customer != null && cryptString.equals(customer.getCusPass())) {
            return customer;
        } else {
            return null;
        }
    }

    @Override
    public Integer cusRegister(String cusName, String cusPass) throws NoSuchAlgorithmException {
        String cryptString = MD5.MD5Creator(cusPass);
        if (customersDao.countCusByName(cusName) != 0) {
            return 3;
        }
        if (customersDao.insertCus(cusName, cryptString) == 1) {
            return 1;
        } else {
            return 2;
        }
    }
}
