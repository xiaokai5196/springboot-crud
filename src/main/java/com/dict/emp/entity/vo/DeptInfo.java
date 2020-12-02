package com.dict.emp.entity.vo;

import com.dict.emp.entity.Emp;

import java.io.Serializable;
import java.util.List;

public class DeptInfo implements Serializable {
    private static final long serialVersionUID = 9115295657814160481L;

    private Integer deptno;

    private String dname;

    private String loc;

    private List<Emp> empList;

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

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("deptno=").append(deptno);
        sb.append(", dname=").append(dname);
        sb.append(", loc=").append(loc);
        sb.append(", empList=").append(empList);
        sb.append("]");
        return sb.toString();
    }
}
