package com.smacul.demo.bean;

import java.sql.Timestamp;
import java.util.Date;

public class CustomerCustomerFollow {

    private Integer ccfId;
    private Integer ccfFollowerId;
    private Integer ccfFolloweeId;
    private Timestamp ccfTime;

    public Integer getCcfId() {
        return ccfId;
    }

    public void setCcfId(Integer ccfId) {
        this.ccfId = ccfId;
    }

    public Integer getCcfFollowerId() {
        return ccfFollowerId;
    }

    public void setCcfFollowerId(Integer ccfFollowerId) {
        this.ccfFollowerId = ccfFollowerId;
    }

    public Integer getCcfFolloweeId() {
        return ccfFolloweeId;
    }

    public void setCcfFolloweeId(Integer ccfFolloweeId) {
        this.ccfFolloweeId = ccfFolloweeId;
    }

    public Timestamp getCcfTime() {
        return ccfTime;
    }

    public void setCcfTime(Timestamp ccfTime) {
        this.ccfTime = ccfTime;
    }

    @Override
    public String toString() {
        return "CustomerCustomerFollow{" +
                "ccfId=" + ccfId +
                ", ccfFollowerId=" + ccfFollowerId +
                ", ccfFolloweeId=" + ccfFolloweeId +
                ", ccfTime=" + ccfTime +
                '}';
    }


}
