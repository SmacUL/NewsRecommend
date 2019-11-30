package com.smacul.demo.service;

import com.smacul.demo.model.CustomerModel;

public interface SelfService {
    CustomerModel getCustomerInfoByArtId(Integer artId);
    CustomerModel getCustomerInfoByCusId(Integer cusId);
}
