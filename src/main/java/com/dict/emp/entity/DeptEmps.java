package com.dict.emp.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "dept")
public class DeptEmps {

//    @Value("${dept.dpetno}")
    private Integer deptno;

    private String dname;

    private String loc;

    private Salgrade salgrade;

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

    public Salgrade getSalgrade() {
        return salgrade;
    }

    public void setSalgrade(Salgrade salgrade) {
        this.salgrade = salgrade;
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
        sb.append(", salgrade=").append(salgrade);
        sb.append(", empList=").append(empList);
        sb.append("]");
        return sb.toString();
    }
}