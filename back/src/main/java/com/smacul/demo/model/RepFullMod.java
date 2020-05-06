package com.smacul.demo.model;

import com.smacul.demo.bean.Customer;

import java.sql.Timestamp;

public class RepFullMod {

    private Integer repId;
    private String repContent;

    private Integer repType;
    private Timestamp repTime;
    private Integer repLegal;
    private String repSpider;

    private Integer repCusId;
    private Integer repArtId;
    private Integer repComId;
    private Integer repRepId;

    private Customer customer;

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public String getRepContent() {
        return repContent;
    }

    public void setRepContent(String repContent) {
        this.repContent = repContent;
    }

    public Integer getRepType() {
        return repType;
    }

    public void setRepType(Integer repType) {
        this.repType = repType;
    }

    public Timestamp getRepTime() {
        return repTime;
    }

    public void setRepTime(Timestamp repTime) {
        this.repTime = repTime;
    }

    public Integer getRepLegal() {
        return repLegal;
    }

    public void setRepLegal(Integer repLegal) {
        this.repLegal = repLegal;
    }

    public String getRepSpider() {
        return repSpider;
    }

    public void setRepSpider(String repSpider) {
        this.repSpider = repSpider;
    }

    public Integer getRepCusId() {
        return repCusId;
    }

    public void setRepCusId(Integer repCusId) {
        this.repCusId = repCusId;
    }

    public Integer getRepArtId() {
        return repArtId;
    }

    public void setRepArtId(Integer repArtId) {
        this.repArtId = repArtId;
    }

    public Integer getRepComId() {
        return repComId;
    }

    public void setRepComId(Integer repComId) {
        this.repComId = repComId;
    }

    public Integer getRepRepId() {
        return repRepId;
    }

    public void setRepRepId(Integer repRepId) {
        this.repRepId = repRepId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
