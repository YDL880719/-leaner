package com.sxs.entity;

public class UserProfession {
    private Long pfid;

    private Long userid;

    private Integer pfschool;

    private Integer pfdept;

    private Integer pfmajor;

    private String pffocus;

    private String pfaddress;

    private String pfkeywords;

    public Long getPfid() {
        return pfid;
    }

    public void setPfid(Long pfid) {
        this.pfid = pfid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getPfschool() {
        return pfschool;
    }

    public void setPfschool(Integer pfschool) {
        this.pfschool = pfschool;
    }

    public Integer getPfdept() {
        return pfdept;
    }

    public void setPfdept(Integer pfdept) {
        this.pfdept = pfdept;
    }

    public Integer getPfmajor() {
        return pfmajor;
    }

    public void setPfmajor(Integer pfmajor) {
        this.pfmajor = pfmajor;
    }

    public String getPffocus() {
        return pffocus;
    }

    public void setPffocus(String pffocus) {
        this.pffocus = pffocus == null ? null : pffocus.trim();
    }

    public String getPfaddress() {
        return pfaddress;
    }

    public void setPfaddress(String pfaddress) {
        this.pfaddress = pfaddress == null ? null : pfaddress.trim();
    }

    public String getPfkeywords() {
        return pfkeywords;
    }

    public void setPfkeywords(String pfkeywords) {
        this.pfkeywords = pfkeywords == null ? null : pfkeywords.trim();
    }
}