package com.smacul.demo.model;

public class CusArtBehaviorMod {
    private Integer cusId;
    private Integer artId;
    private Integer preference;
    private Boolean isFollow;
    private Boolean isRead;
    private Boolean isArtAuthor;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public Integer getPreference() {
        return preference;
    }

    public void setPreference(Integer preference) {
        this.preference = preference;
    }

    public Boolean getFollow() {
        return isFollow;
    }

    public void setFollow(Boolean follow) {
        isFollow = follow;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Boolean getArtAuthor() {
        return isArtAuthor;
    }

    public void setArtAuthor(Boolean artAuthor) {
        isArtAuthor = artAuthor;
    }
}
