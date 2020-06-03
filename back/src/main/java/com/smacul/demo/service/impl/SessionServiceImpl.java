package com.smacul.demo.service.impl;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.service.SessionService;
import com.smacul.demo.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    HttpSession session;

    private static final String CUS = "customer";
    private static final String REL = "relative";
    private static final String PAG = "pages";

    @Override
    public void setCusSession(Customer cus) {
        session.setAttribute(CUS, cus);
    }

    @Override
    public void setRelSession(List<Integer> rel) {
        session.setAttribute(REL, rel);
    }

    @Override
    public Customer getCusSession() {
        return (Customer) session.getAttribute(CUS);
    }

    @Override
    public List<Integer> getRelSession() {
        return (List<Integer>) session.getAttribute(REL);
    }

    @Override
    public void initPagSession() {
        session.setAttribute(PAG, PageHandler.initPageList());
    }

    @Override
    public Integer getPagThenAddOne(String category) {
        Map<String, Integer> pages = (Map<String, Integer>)session.getAttribute(PAG);
        Integer pag = 0;
        if (category.equals("news_hot")) {
            pag = pages.get("news_hot");
            if (pag > 4) {
                pages.replace("news_hot", 0);
            } else {
                pages.replace("news_hot", pag+1);
            }
        } else {
            pag = pages.get(category);
            pages.replace(category, pag+1);
        }
        session.setAttribute(PAG, pages);
        return pag;
    }

    @Override
    public Integer getSetPagAfterCusChange(String category) {
        Map<String, Integer> pages = (Map<String, Integer>)session.getAttribute(PAG);
        pages.replace(category, 0);
        session.setAttribute(PAG, pages);
        return 0;
    }

    //public void setSession(String name, Object object) {
    //    switch (name) {
    //        case CUS:
    //            session.setAttribute(CUS, object);
    //            break;
    //        case REL:
    //            session.setAttribute(REL, object);
    //            break ;
    //
    //    }
    //}
    //
    //public Object getSession(String name) {
    //    switch (name) {
    //        case CUS:
    //            session.getAttribute(CUS);
    //            break;
    //        case REL:
    //            session.getAttribute(REL);
    //            break ;
    //    }
    //}
    //

}
