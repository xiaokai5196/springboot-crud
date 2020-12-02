package com.dict.emp.entity.vo;

import com.dict.emp.entity.Dept;
import com.dict.emp.entity.Salgrade;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class EmpDetail implements Serializable {

    private static final long serialVersionUID = 3235464791144015481L;

    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", locale = "zh_CN")
    private Date hiredate;

    private Float sal;

    private Float comm;

    private Dept dept;

    private Salgrade salGrade;

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
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Salgrade getSalGrade() {
        return salGrade;
    }

    public void setSalGrade(Salgrade salGrade) {
        this.salGrade = salGrade;
    }

    @Override
    public String toString() {
        return "EmpDetail{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", dept=" + dept +
                ", salGrade=" + salGrade +
                '}';
    }
}
