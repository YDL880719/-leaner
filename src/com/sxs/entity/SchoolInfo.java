package com.sxs.entity;

public class SchoolInfo {
    private Long schid;

    private String schname;

    private String schaddress;

    private String schphone;

    private String schdes;

    public Long getSchid() {
        return schid;
    }

    public void setSchid(Long schid) {
        this.schid = schid;
    }

    public String getSchname() {
        return schname;
    }

    public void setSchname(String schname) {
        this.schname = schname == null ? null : schname.trim();
    }

    public String getSchaddress() {
        return schaddress;
    }

    public void setSchaddress(String schaddress) {
        this.schaddress = schaddress == null ? null : schaddress.trim();
    }

    public String getSchphone() {
        return schphone;
    }

    public void setSchphone(String schphone) {
        this.schphone = schphone == null ? null : schphone.trim();
    }

    public String getSchdes() {
        return schdes;
    }

    public void setSchdes(String schdes) {
        this.schdes = schdes == null ? null : schdes.trim();
    }
}