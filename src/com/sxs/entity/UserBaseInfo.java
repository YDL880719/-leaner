package com.sxs.entity;

public class UserBaseInfo {
    private Long userid;

    private String usermobile;

    private String userpwd;

    private String usercode;

    private String usertoken;

    private Integer usertype;

    private String userregtime;

    private String userlatesttime;

    private Integer userisfirst;

    private Integer userisable;

    private Integer userupiscomplete;

    private Integer userpfiscomplete;

    private Integer usercviscomplete;

    private String userdes;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile == null ? null : usermobile.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken == null ? null : usertoken.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getUserregtime() {
        return userregtime;
    }

    public void setUserregtime(String userregtime) {
        this.userregtime = userregtime == null ? null : userregtime.trim();
    }

    public String getUserlatesttime() {
        return userlatesttime;
    }

    public void setUserlatesttime(String userlatesttime) {
        this.userlatesttime = userlatesttime == null ? null : userlatesttime.trim();
    }

    public Integer getUserisfirst() {
        return userisfirst;
    }

    public void setUserisfirst(Integer userisfirst) {
        this.userisfirst = userisfirst;
    }

    public Integer getUserisable() {
        return userisable;
    }

    public void setUserisable(Integer userisable) {
        this.userisable = userisable;
    }

    public Integer getUserupiscomplete() {
        return userupiscomplete;
    }

    public void setUserupiscomplete(Integer userupiscomplete) {
        this.userupiscomplete = userupiscomplete;
    }

    public Integer getUserpfiscomplete() {
        return userpfiscomplete;
    }

    public void setUserpfiscomplete(Integer userpfiscomplete) {
        this.userpfiscomplete = userpfiscomplete;
    }

    public Integer getUsercviscomplete() {
        return usercviscomplete;
    }

    public void setUsercviscomplete(Integer usercviscomplete) {
        this.usercviscomplete = usercviscomplete;
    }

    public String getUserdes() {
        return userdes;
    }

    public void setUserdes(String userdes) {
        this.userdes = userdes == null ? null : userdes.trim();
    }
}