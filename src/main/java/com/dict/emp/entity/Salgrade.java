package com.dict.emp.entity;

import java.io.Serializable;

public class Salgrade implements Serializable {
    private static final long serialVersionUID = -1067823083979919161L;
    private Integer grade;

    private Integer losal;

    private Integer hisal;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getLosal() {
        return losal;
    }

    public void setLosal(Integer losal) {
        this.losal = losal;
    }

    public Integer getHisal() {
        return hisal;
    }

    public void setHisal(Integer hisal) {
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("grade=").append(grade);
        sb.append(", losal=").append(losal);
        sb.append(", hisal=").append(hisal);
        sb.append("]");
        return sb.toString();
    }
}