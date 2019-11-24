package com.smacul.demo.bean;

import java.sql.Timestamp;

public class ReplyCustomerPreference {
    private Integer rcpId;
    private Integer rcpReplyId;
    private Integer rcpCustomerId;
    private Integer rcpPreference;
    private Timestamp rcpTime;

    @Override
    public String toString() {
        return "ReplyCustomerPreference{" +
                "rcpId=" + rcpId +
                ", rcpReplyId=" + rcpReplyId +
                ", rcpCustomerId=" + rcpCustomerId +
                ", rcpPreference=" + rcpPreference +
                ", rcpTime=" + rcpTime +
                '}';
    }

    public Integer getRcpId() {
        return rcpId;
    }

    public void setRcpId(Integer rcpId) {
        this.rcpId = rcpId;
    }

    public Integer getRcpReplyId() {
        return rcpReplyId;
    }

    public void setRcpReplyId(Integer rcpReplyId) {
        this.rcpReplyId = rcpReplyId;
    }

    public Integer getRcpCustomerId() {
        return rcpCustomerId;
    }

    public void setRcpCustomerId(Integer rcpCustomerId) {
        this.rcpCustomerId = rcpCustomerId;
    }

    public Integer getRcpPreference() {
        return rcpPreference;
    }

    public void setRcpPreference(Integer rcpPreference) {
        this.rcpPreference = rcpPreference;
    }

    public Timestamp getRcpTime() {
        return rcpTime;
    }

    public void setRcpTime(Timestamp rcpTime) {
        this.rcpTime = rcpTime;
    }



}
