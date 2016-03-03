package com.sxs.entity;

public class UserAction {
    private Long uactid;

    private Long userid;

    private String uactopr;

    private String uactoprtime;

    private String uactdata;

    private Integer uactresult;

    public Long getUactid() {
        return uactid;
    }

    public void setUactid(Long uactid) {
        this.uactid = uactid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUactopr() {
        return uactopr;
    }

    public void setUactopr(String uactopr) {
        this.uactopr = uactopr == null ? null : uactopr.trim();
    }

    public String getUactoprtime() {
        return uactoprtime;
    }

    public void setUactoprtime(String uactoprtime) {
        this.uactoprtime = uactoprtime == null ? null : uactoprtime.trim();
    }

    public String getUactdata() {
        return uactdata;
    }

    public void setUactdata(String uactdata) {
        this.uactdata = uactdata == null ? null : uactdata.trim();
    }

    public Integer getUactresult() {
        return uactresult;
    }

    public void setUactresult(Integer uactresult) {
        this.uactresult = uactresult;
    }
}