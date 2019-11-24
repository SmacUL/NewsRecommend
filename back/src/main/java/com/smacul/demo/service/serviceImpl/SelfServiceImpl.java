package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.SelfMapper;
import com.smacul.demo.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SelfServiceImpl implements SelfService {

    @Autowired
    SelfMapper selfMapper;

    @Autowired
    HttpSession session;

}
