package com.smacul.demo.service.impl;

import com.smacul.demo.bean.Article;
import com.smacul.demo.bean.CusBehaviorRecord;
import com.smacul.demo.dao.ArtDao;
import com.smacul.demo.dao.CusBehaviorRecordDao;
import com.smacul.demo.dao.CusFeatureCountDao;
import com.smacul.demo.model.ArtFullMod;
import com.smacul.demo.model.CusArtBehaviorMod;
import com.smacul.demo.service.LoadService;
import com.smacul.demo.util.PageHandler;
import com.smacul.demo.util.TypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    ArtDao artDao;
    @Autowired
    CusFeatureCountDao cusFeatureCountDao;
    @Autowired
    CusBehaviorRecordDao cusBehaviorRecordDao;

    @Override
    public List<String> getArtTypesForNew() {
        List<String> result = artDao.getArtTypesOrderByTypeNum();
        return TypeHandler.typeTransAllEnToCh(result);
    }

    @Override
    public List<String> getArtTypesForOld(Integer cusId) {
        //List<Integer> nums = cusFeatureCountDao.getCusArtTypesBehaviorNums(cusId);
        //return null;
        List<String> result = artDao.getArtTypesOrderByTypeNum();
        return TypeHandler.typeTransAllEnToCh(result);
    }

    @Override
    public List<ArtFullMod> getTinyArtOnePageByTypeForNew(String artType, Integer page, Integer pageSize) {
        Integer start = PageHandler.calcuStartNO(page, pageSize);
        if (artType.equals("综合")) {
            return artDao.getTinyArtOnePageFromGlobal(start, pageSize);
        } else {
            return artDao.getTinyArtOnePageByType(TypeHandler.typeTransSingleChToEn(artType), start, pageSize);
        }
    }

    @Override
    public List<ArtFullMod> getTinyArtOnePageByTypeForOld(String artType, Integer page, Integer pageSize) {
        Integer start = PageHandler.calcuStartNO(page, pageSize);
        if (artType.equals("综合")) {
            return artDao.getTinyArtOnePageFromGlobal(start, pageSize);
        } else {
            return artDao.getTinyArtOnePageByType(TypeHandler.typeTransSingleChToEn(artType), start, pageSize);
        }
    }

    @Override
    public List<ArtFullMod> getHotArtOnePage(Integer page, Integer pageSize) {
        Integer start = 0;
        if (page <= 4) {
            start = PageHandler.calcuStartNO(page, pageSize);
        }
        return artDao.getHotArtOnePage(start, pageSize);
    }

    @Override
    public ArtFullMod getFullArt(Integer cusId, Integer artId) {
        ArtFullMod artFullMod = artDao.getArtFull(artId);
        CusArtBehaviorMod behaviorMod = new CusArtBehaviorMod();
        behaviorMod.setArtId(artId);
        behaviorMod.setCusId(cusId);
        // 是否阅读过此文章
        if (cusBehaviorRecordDao.countTargetCusArtBehaviorFrom(cusId, artId, 2) >= 1) {
            behaviorMod.setRead(true);
        } else {
            behaviorMod.setRead(false);
        }
        // 是否点赞
        if (cusBehaviorRecordDao.countTargetCusArtBehaviorFrom(cusId, artId, 3) == 1) {
            behaviorMod.setPreference(1);
        } else if (cusBehaviorRecordDao.countTargetCusArtBehaviorFrom(cusId, artId, 4) == 1) {
            behaviorMod.setPreference(-1);
        } else {
            behaviorMod.setPreference(0);
        }
        // 是否是文章作者
        if (cusBehaviorRecordDao.countTargetCusArtBehaviorFrom(cusId, artId, 1) == 1) {
            behaviorMod.setArtAuthor(true);
        } else {
            behaviorMod.setArtAuthor(false);
        }
        // 是否关注了文章作者
        if (cusBehaviorRecordDao.countTargetCusFollowBehavior(cusId, artFullMod.getArtCusId()) == 1) {
            behaviorMod.setFollow(true);
        } else {
            behaviorMod.setRead(false);
        }
        artFullMod.setCusArtBehavior(behaviorMod);
        return artFullMod;
    }

    @Override
    public String setArtPreference(Integer artId, Integer type) {
        return null;
    }
}
