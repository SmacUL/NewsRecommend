package com.smacul.demo.service;

import com.smacul.demo.bean.Customer;

import java.security.NoSuchAlgorithmException;

public interface SelfService {

    Customer cusLogin(String cusName, String cusPass) throws NoSuchAlgorithmException;

    Integer cusRegister(String cusName, String cusPass) throws NoSuchAlgorithmException;
}
