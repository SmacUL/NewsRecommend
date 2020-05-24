package com.smacul.demo.service;

import com.smacul.demo.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface SessionService {

    void setCusSession(Customer cus);

    void setRelSession(List<Integer> rel);

    Customer getCusSession();

    List<Integer> getRelSession();

    Integer getPagThenAddOne(String category);

    Integer getSetPagAfterCusChange(String category);

    void initPagSession();

}
