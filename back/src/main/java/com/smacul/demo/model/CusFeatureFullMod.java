package com.smacul.demo.model;

import com.smacul.demo.bean.CusFeatureCount;

public class CusFeatureFullMod {
    private Integer cusId;
    private Integer readNum;
    private Integer fanNum;
    private Integer followNum;

    private Integer artEditNum;
    private Integer comEditNum;
    private Integer repEditNum;

    private CusFeatureCount featureCount;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getFanNum() {
        return fanNum;
    }

    public void setFanNum(Integer fanNum) {
        this.fanNum = fanNum;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public Integer getArtEditNum() {
        return artEditNum;
    }

    public void setArtEditNum(Integer artEditNum) {
        this.artEditNum = artEditNum;
    }

    public Integer getComEditNum() {
        return comEditNum;
    }

    public void setComEditNum(Integer comEditNum) {
        this.comEditNum = comEditNum;
    }

    public Integer getRepEditNum() {
        return repEditNum;
    }

    public void setRepEditNum(Integer repEditNum) {
        this.repEditNum = repEditNum;
    }

    public CusFeatureCount getFeatureCount() {
        return featureCount;
    }

    public void setFeatureCount(CusFeatureCount featureCount) {
        this.featureCount = featureCount;
    }
}
