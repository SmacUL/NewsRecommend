package com.smacul.demo.model;

import com.smacul.demo.bean.Customer;
//import com.smacul.demo.bean.Reply;

import java.sql.Timestamp;
import java.util.List;

public class ComFullMod {
    private Integer comId;
    private String comContent;
    private Timestamp comTime;
    private Integer comLegal;
    private String comSpider;

    private Integer comCusId;
    private Integer comArtId;

    private Customer customer;
    private List<RepFullMod> replys;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Timestamp getComTime() {
        return comTime;
    }

    public void setComTime(Timestamp comTime) {
        this.comTime = comTime;
    }

    public Integer getComLegal() {
        return comLegal;
    }

    public void setComLegal(Integer comLegal) {
        this.comLegal = comLegal;
    }

    public String getComSpider() {
        return comSpider;
    }

    public void setComSpider(String comSpider) {
        this.comSpider = comSpider;
    }

    public Integer getComCusId() {
        return comCusId;
    }

    public void setComCusId(Integer comCusId) {
        this.comCusId = comCusId;
    }

    public Integer getComArtId() {
        return comArtId;
    }

    public void setComArtId(Integer comArtId) {
        this.comArtId = comArtId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<RepFullMod> getReplys() {
        return replys;
    }

    public void setReplys(List<RepFullMod> replys) {
        this.replys = replys;
    }
}
