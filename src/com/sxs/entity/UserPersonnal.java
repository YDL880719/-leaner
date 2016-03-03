package com.sxs.entity;

public class UserPersonnal {
    private Long upid;

    private Long userid;

    private String uprealname;

    private String upnike;

    private Integer upmale;

    private String upicon;

    private String upqq;

    private String upwechat;

    private String uprenger;

    public Long getUpid() {
        return upid;
    }

    public void setUpid(Long upid) {
        this.upid = upid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUprealname() {
        return uprealname;
    }

    public void setUprealname(String uprealname) {
        this.uprealname = uprealname == null ? null : uprealname.trim();
    }

    public String getUpnike() {
        return upnike;
    }

    public void setUpnike(String upnike) {
        this.upnike = upnike == null ? null : upnike.trim();
    }

    public Integer getUpmale() {
        return upmale;
    }

    public void setUpmale(Integer upmale) {
        this.upmale = upmale;
    }

    public String getUpicon() {
        return upicon;
    }

    public void setUpicon(String upicon) {
        this.upicon = upicon == null ? null : upicon.trim();
    }

    public String getUpqq() {
        return upqq;
    }

    public void setUpqq(String upqq) {
        this.upqq = upqq == null ? null : upqq.trim();
    }

    public String getUpwechat() {
        return upwechat;
    }

    public void setUpwechat(String upwechat) {
        this.upwechat = upwechat == null ? null : upwechat.trim();
    }

    public String getUprenger() {
        return uprenger;
    }

    public void setUprenger(String uprenger) {
        this.uprenger = uprenger == null ? null : uprenger.trim();
    }
}