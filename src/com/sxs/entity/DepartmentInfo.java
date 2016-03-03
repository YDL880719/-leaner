package com.sxs.entity;

public class DepartmentInfo {
    private Long depid;

    private String depname;

    private String depdes;

    private Long schid;

    public Long getDepid() {
        return depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname == null ? null : depname.trim();
    }

    public String getDepdes() {
        return depdes;
    }

    public void setDepdes(String depdes) {
        this.depdes = depdes == null ? null : depdes.trim();
    }

    public Long getSchid() {
        return schid;
    }

    public void setSchid(Long schid) {
        this.schid = schid;
    }
}