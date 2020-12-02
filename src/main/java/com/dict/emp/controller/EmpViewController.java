package com.dict.emp.controller;

import com.alibaba.fastjson.JSONObject;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/view")
public class EmpViewController {

    private Logger logger = LoggerFactory.getLogger(EmpViewController.class);

    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private HttpServletRequest request;

    /*多个映射路径到同一方法，无法传参，null*/
    @RequestMapping(value = {"/test1", "/test11"})
    public String test1(){
        return "test";
    }

    /*指定请求方式为POST*/
    @RequestMapping(value = "/test12",method = RequestMethod.POST)
    @ResponseBody
    public String test12(){
        return "请求方式为post";
    }

    /*指定请求类型Content-Type为json */
    @RequestMapping(value = "/test13", consumes="application/json")
    public String test13(@RequestBody JSONObject param){
        return "test";
    }

    /*指定返回类型为json
    * 即必须有@ResponseBody注解
    */
    @RequestMapping(value = "/test14",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String test14(){
        return "zhangsan";
    }

    /*指定仅处理请求中包含了名为“key”，值为“value”的请求*/
    @RequestMapping(value = "/test15",method = RequestMethod.POST,params = "name=zhangsan")
    @ResponseBody
    public String test15(String name, Integer age){
        return name + ":" + age;
    }

    /*仅处理request的header中包含了指定“key”请求头和对应值为“value”的请求*/
    @RequestMapping(value = "/test16", headers = "token=1001")
    @ResponseBody
    public String test16(String name){
        String token = request.getHeader("token").toString();
        return token + "：" + name;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(@RequestParam("name") String ename, @RequestParam Integer age ){
        return ename + "：" +age;
    }

    @RequestMapping(value = "/testEmp", method = RequestMethod.POST)
    @ResponseBody
    public Emp testEmp(Emp emp){
        System.out.println(emp);
        return emp;
    }


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
