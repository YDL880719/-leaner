package com.sxs.entity;

public class MajorInfo {
    private Long majid;

    private String majname;

    private String majdes;

    private Long schid;

    public Long getMajid() {
        return majid;
    }

    public void setMajid(Long majid) {
        this.majid = majid;
    }

    public String getMajname() {
        return majname;
    }

    public void setMajname(String majname) {
        this.majname = majname == null ? null : majname.trim();
    }

    public String getMajdes() {
        return majdes;
    }

    public void setMajdes(String majdes) {
        this.majdes = majdes == null ? null : majdes.trim();
    }

    public Long getSchid() {
        return schid;
    }

    public void setSchid(Long schid) {
        this.schid = schid;
    }
}