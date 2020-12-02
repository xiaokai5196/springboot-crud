package com.dict.emp.entity;


import java.io.Serializable;

public class Dept implements Serializable {
    private static final long serialVersionUID = 1082482673035292633L;
    private Integer deptno;

    private String dname;

    private String loc;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("deptno=").append(deptno);
        sb.append(", dname=").append(dname);
        sb.append(", loc=").append(loc);
        sb.append("]");
        return sb.toString();
    }
}