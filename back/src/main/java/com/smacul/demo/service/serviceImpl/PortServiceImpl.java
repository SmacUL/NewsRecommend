package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class PortServiceImpl implements PortService {

    @Autowired
    HttpSession session;

}
