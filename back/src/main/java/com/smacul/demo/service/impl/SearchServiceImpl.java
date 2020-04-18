package com.smacul.demo.service.impl;

import com.smacul.demo.model.ArtFullMod;
import com.smacul.demo.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {


    @Override
    public List<ArtFullMod> searchContentSimple(String key, Integer page, Integer pageSize) {
        return null;
    }
}
