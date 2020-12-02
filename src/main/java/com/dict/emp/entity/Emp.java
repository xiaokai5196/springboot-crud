package com.dict.emp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
    private static final long serialVersionUID = -397892406911561126L;
    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hiredate;

    private Float sal;

    private Float comm;

    private Integer deptno;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Float getSal() {
        return sal;
    }

    public void setSal(Float sal) {
        this.sal = sal;
    }

    public Float getComm() {
        return comm;
    }

    public void setComm(Float comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("empno=").append(empno);
        sb.append(", ename=").append(ename);
        sb.append(", job=").append(job);
        sb.append(", mgr=").append(mgr);
        sb.append(", hiredate=").append(hiredate);
        sb.append(", sal=").append(sal);
        sb.append(", comm=").append(comm);
        sb.append(", deptno=").append(deptno);
        sb.append("]");
        return sb.toString();
    }
}