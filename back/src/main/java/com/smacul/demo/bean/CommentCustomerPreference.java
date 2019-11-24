package com.smacul.demo.bean;

import java.sql.Timestamp;

public class CommentCustomerPreference {
    private Integer ccpId;
    private Integer ccpCommentId;
    private Integer ccpCustomerId;
    private Integer ccpPreference;
    private Timestamp ccpTime;

    @Override
    public String toString() {
        return "CommentCustomerPreference{" +
                "ccpId=" + ccpId +
                ", ccpCommentId=" + ccpCommentId +
                ", ccpCustomerId=" + ccpCustomerId +
                ", ccpPreference=" + ccpPreference +
                ", ccpTime=" + ccpTime +
                '}';
    }

    public Integer getCcpId() {
        return ccpId;
    }

    public void setCcpId(Integer ccpId) {
        this.ccpId = ccpId;
    }

    public Integer getCcpCommentId() {
        return ccpCommentId;
    }

    public void setCcpCommentId(Integer ccpCommentId) {
        this.ccpCommentId = ccpCommentId;
    }

    public Integer getCcpCustomerId() {
        return ccpCustomerId;
    }

    public void setCcpCustomerId(Integer ccpCustomerId) {
        this.ccpCustomerId = ccpCustomerId;
    }

    public Integer getCcpPreference() {
        return ccpPreference;
    }

    public void setCcpPreference(Integer ccpPreference) {
        this.ccpPreference = ccpPreference;
    }

    public Timestamp getCcpTime() {
        return ccpTime;
    }

    public void setCcpTime(Timestamp ccpTime) {
        this.ccpTime = ccpTime;
    }



}
