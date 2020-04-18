package com.smacul.demo.service;

import com.smacul.demo.model.ArtFullMod;

import java.util.List;

public interface LoadService {

    List<String> getArtTypesForNew();

    List<String> getArtTypesForOld();

    List<ArtFullMod> getTinyArtOnePageByTypeForNew(String artType, Integer page, Integer pageSize);

    List<ArtFullMod> getTinyArtOnePageByTypeForOld(String artType, Integer page, Integer pageSize);

    List<ArtFullMod> getHotArtOnePage(Integer page, Integer pageSize);

    ArtFullMod getFullArt(Integer artId);

    String setArtPreference(Integer artId, Integer type);

}
