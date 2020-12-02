package com.dict.emp.controller;

import com.dict.emp.entity.Dept;
import com.dict.emp.entity.Emp;
import com.dict.emp.service.DeptService;
import com.dict.emp.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class EmpViewController {

    private Logger logger = LoggerFactory.getLogger(EmpViewController.class);

    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    @RequestMapping("/empList")
    public String selectEmpList(Model model){
        List<Emp> emps = empService.selectEmpList();
        model.addAttribute("emps",emps);
        return "emp/empList";
    }

    @RequestMapping("/deptList")
    public String selectDeptList(Model model){
        List<Dept> depts = deptService.selectDeptList();
        model.addAttribute("depts",depts);
        return "emp/deptList";
    }






}
