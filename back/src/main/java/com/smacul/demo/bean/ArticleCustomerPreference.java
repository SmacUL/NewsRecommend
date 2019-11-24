package com.smacul.demo.bean;

import java.sql.Timestamp;

public class ArticleCustomerPreference {
    private Integer acpId;
    private Integer acpArticleId;
    private Integer acpCustomId;
    private Integer acpPreference;
    private Timestamp acpTime;

    @Override
    public String toString() {
        return "ArticleCustomerPreference{" +
                "acpId=" + acpId +
                ", acpArticleId=" + acpArticleId +
                ", acpCustomId=" + acpCustomId +
                ", acpPreference=" + acpPreference +
                ", acpTime=" + acpTime +
                '}';
    }

    public Integer getAcpId() {
        return acpId;
    }

    public void setAcpId(Integer acpId) {
        this.acpId = acpId;
    }

    public Integer getAcpArticleId() {
        return acpArticleId;
    }

    public void setAcpArticleId(Integer acpArticleId) {
        this.acpArticleId = acpArticleId;
    }

    public Integer getAcpCustomId() {
        return acpCustomId;
    }

    public void setAcpCustomId(Integer acpCustomId) {
        this.acpCustomId = acpCustomId;
    }

    public Integer getAcpPreference() {
        return acpPreference;
    }

    public void setAcpPreference(Integer acpPreference) {
        this.acpPreference = acpPreference;
    }

    public Timestamp getAcpTime() {
        return acpTime;
    }

    public void setAcpTime(Timestamp acpTime) {
        this.acpTime = acpTime;
    }


}
