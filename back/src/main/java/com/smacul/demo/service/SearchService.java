package com.smacul.demo.service;

import com.smacul.demo.model.ArtFullMod;

import java.util.List;

public interface SearchService {

    List<ArtFullMod> searchContentSimple(String key, Integer page, Integer pageSize);

}
