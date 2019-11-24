package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.dao.IndexMapper;
import com.smacul.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;

    @Autowired
    HttpSession session;

}
