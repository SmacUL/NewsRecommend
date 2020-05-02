package com.smacul.demo.service.impl;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.dao.ArtDao;
import com.smacul.demo.dao.ArtFeatureCountDao;
import com.smacul.demo.dao.CusBehaviorRecordDao;
import com.smacul.demo.dao.CusFeatureCountDao;
import com.smacul.demo.model.ArtFullMod;
import com.smacul.demo.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShapeServiceImpl implements ShapeService {

    @Autowired
    ArtDao artDao;
    @Autowired
    CusBehaviorRecordDao cbrDao;
    @Autowired
    CusFeatureCountDao cusFeatureCountDao;
    @Autowired
    ArtFeatureCountDao artFeatureCountDao;

    @Override
    public Boolean setCusBehaviorArtEdit(Integer cusId, Integer artId) {
        String artType = artDao.getArtTypeByArtId(artId);
        Integer cbr = cbrDao.addCusBehavior(cusId, cusId, 1, artId, 1, artId);
        Integer cfc = cusFeatureCountDao.updateCusFeature(cusId, "cfc_" + artType, 1);
        if (cbr == 1 && cfc == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean setCusBehaviorArtRead(Integer cusId, Integer artId) {
        String artType = artDao.getArtTypeByArtId(artId);
        Integer artCusId = artDao.getArtCusIdByArtId(artId);
        Integer cbr = 0;
        Integer cfc = 0;
        Integer afc = 0;
        Integer readNum = cbrDao.countTargetCusArtBehaviorFrom(cusId, artId, 2);
        if (readNum < 1) {
            cbr = cbrDao.addCusBehavior(cusId, artCusId, 2, artId, 1, artId);
            cfc = cusFeatureCountDao.updateCusFeature(cusId, "cfc_" + artType, 1);
            afc = artFeatureCountDao.updateArtFeature(artId, "afc_read_num", 1);
        }
        if (readNum >=1 || (cbr == 1 && cfc == 1 && afc == 1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean setCusBehaviorArtLike(Integer cusId, Integer artId, Boolean type) {
        String artType = artDao.getArtTypeByArtId(artId);
        Integer artCusId = artDao.getArtCusIdByArtId(artId);
        if (type) {
            Integer cbr = cbrDao.addCusBehavior(cusId, artCusId, 3, artId, 1, artId);
            Integer cfc = cusFeatureCountDao.updateCusFeature(cusId, "cfc_" + artType, 1);
            Integer afc = artFeatureCountDao.updateArtFeature(artId, "afc_like_num", 1);
            if (cbr == 1 && cfc == 1 && afc == 1) {
                return true;
            }
        } else {
            Integer cbr = cbrDao.deleteCusBehavior(cusId, artCusId, 3, artId, 1, artId);
            Integer cfc = cusFeatureCountDao.updateCusFeature(cusId, "cfc_" + artType, -1);
            Integer afc = artFeatureCountDao.updateArtFeature(artId, "afc_like_num", -1);
            if (cbr == 1 && cfc == 1 && afc == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean setCusBehaviorArtDislike(Integer cusId, Integer artId, Boolean type) {
        String artType = artDao.getArtTypeByArtId(artId);
        Integer artCusId = artDao.getArtCusIdByArtId(artId);
        if (type) {
            Integer cbr = cbrDao.addCusBehavior(cusId, artCusId, 4, artId, 1, artId);
            Integer cfc = cusFeatureCountDao.updateCusFeature(cusId, "cfc_" + artType, 1);
            Integer afc = artFeatureCountDao.updateArtFeature(artId, "afc_dislike_num", 1);
            if (cbr == 1 && cfc == 1 && afc == 1) {
                return true;
            }
        } else {
            Integer cbr = cbrDao.deleteCusBehavior(cusId, artCusId, 4, artId, 1, artId);
            Integer cfc = cusFeatureCountDao.updateCusFeature(cusId, "cfc_" + artType, -1);
            Integer afc = artFeatureCountDao.updateArtFeature(artId, "afc_dislike_num", -1);
            if (cbr == 1 && cfc == 1 && afc == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean setCusBehaviorComEdit(Integer cusId, Integer artId, Integer comId) {
//        String artType = artDao.getArtTypeByArtId(artId);
        ArtFullMod artFull = artDao.getArtFull(artId);
        Integer cbr = cbrDao.addCusBehavior(cusId, artFull.getArtCusId(), 5, artId, 2, comId);
        Integer cfc = cusFeatureCountDao.updateCusFeature(cusId, "cfc_" + artFull.getArtType(), 1);
        Integer afc = artFeatureCountDao.updateArtFeature(artId, "afc_com_num", 1);
        if (cbr == 1 && cfc == 1 && afc == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean setCusBehaviorComLike(Integer cusId, Integer comCusId, Integer artId, Integer comId) {
        return null;
    }

    @Override
    public Boolean setCusBehaviorComDislike(Integer cusId, Integer comCusId, Integer artId, Integer comId) {
        return null;
    }

    @Override
    public Boolean setCusBehaviorRepEdit(Integer cusId, Integer artId, Integer repId) {
//        String artType = artDao.getArtTypeByArtId(artId);
        ArtFullMod artFull = artDao.getArtFull(artId);
        Integer cbr = cbrDao.addCusBehavior(cusId, artFull.getArtCusId(), 8, artId, 3, repId);
        Integer cfc = cusFeatureCountDao.updateCusFeature(cusId, "cfc_" + artFull.getArtType(), 1);
        Integer afc = artFeatureCountDao.updateArtFeature(artId, "afc_rep_num", 1);
        if (cbr == 1 && cfc == 1 && afc == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean setCusBehaviorRepLike(Integer cusId, Integer repCusId, Integer artId, Integer repId) {
        return null;
    }

    @Override
    public Boolean setCusBehaviorRepDislike(Integer cusId, Integer repCusId, Integer artId, Integer repId) {
        return null;
    }

    @Override
    public Boolean setCusBehaviorCusFollow(Integer cusIdFrom, Integer cusIdTo) {
        if (cbrDao.addCusBehavior(cusIdFrom, cusIdTo, 9, null, 0, null) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
