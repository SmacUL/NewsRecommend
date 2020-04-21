package com.smacul.demo.service.impl;

import com.smacul.demo.dao.ArtDao;
import com.smacul.demo.model.ArtFullMod;
import com.smacul.demo.service.SearchService;
import com.smacul.demo.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ArtDao artDao;

    @Override
    public List<ArtFullMod> searchContentSimple(String key, Integer page, Integer pageSize) {
        Integer start = PageHandler.calcuStartNO(page, pageSize);
        return artDao.searchContentSimple(key, start, pageSize);
    }
}
