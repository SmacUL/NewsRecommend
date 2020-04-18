package com.smacul.demo.service.impl;

import com.smacul.demo.model.ArtFullMod;
import com.smacul.demo.service.LoadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

    @Override
    public List<String> getArtTypesForNew() {
        return null;
    }

    @Override
    public List<String> getArtTypesForOld() {
        return null;
    }

    @Override
    public List<ArtFullMod> getTinyArtOnePageByTypeForNew(String artType, Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public List<ArtFullMod> getTinyArtOnePageByTypeForOld(String artType, Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public List<ArtFullMod> getHotArtOnePage(Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public ArtFullMod getFullArt(Integer artId) {
        return null;
    }

    @Override
    public String setArtPreference(Integer artId, Integer type) {
        return null;
    }
}
