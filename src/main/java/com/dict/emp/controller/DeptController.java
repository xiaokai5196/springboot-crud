package com.dict.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.common.ReturnUtil;
import com.dict.emp.entity.Dept;
import com.dict.emp.entity.vo.DeptInfo;
import com.dict.emp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门信息
     * @return
     */
    @GetMapping("selectDeptList")
    public JSONObject selectDeptList(){
        List<Dept> depts = deptService.selectDeptList();
        return ReturnUtil.returnSuccess("查询成功", depts);
    }

    /**
     * 根据部门编号查询部门信息
     * @param deptno 部门编号
     * @return
     */
    @GetMapping("/selectById/{deptno}")
    public JSONObject selectById(@PathVariable Integer deptno){
        Dept dept = deptService.selectByPrimaryKey(deptno);
        return ReturnUtil.returnSuccess("查询成功", dept);
    }

    /**
     * 添加部门信息
     * @param dept 部门对象
     * @return
     */
    @PostMapping("/insert")
    public JSONObject insert(@RequestBody Dept dept){
        deptService.insert(dept);
        return ReturnUtil.returnSuccess("添加成功");
    }

    /**
     * 修改部门信息
     * @param dept 部门对象
     * @return
     */
    @PutMapping("/update")
    public JSONObject update(Dept dept){
        deptService.updateByPrimaryKeySelective(dept);
        return ReturnUtil.returnSuccess("修改成功");
    }

    /**
     * 根据部门编号删除部门信息
     * @param deptno 部门编号
     * @return
     */
    @DeleteMapping("/deleteById")
    public JSONObject deleteById(@RequestParam Integer deptno){
        deptService.deleteByPrimaryKey(deptno);
        return ReturnUtil.returnSuccess("删除成功");
    }

    /**
     *查询部门信息及下属所有员工信息
     * @param deptno 部门编号
     * @return
     */
    @GetMapping("/selectDeptInfo")
    public JSONObject selectDeptInfo(Integer deptno){
        List<DeptInfo> deptInfos = deptService.selectDeptInfo(deptno);
        return ReturnUtil.returnSuccess("查询成功", deptInfos);
    }




}
