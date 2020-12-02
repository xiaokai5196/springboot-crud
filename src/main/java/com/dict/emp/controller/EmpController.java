package com.dict.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.common.ReturnUtil;
import com.dict.emp.entity.vo.DeptInfo;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpDetail;
import com.dict.emp.entity.vo.EmpInfo;
import com.dict.emp.service.EmpService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {

    private Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empService;

    /**
     * 分页条件查询
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @param ename 模糊查询条件-员工姓名
     * @param deptno 查询条件-部门编号
     * @return
     */
    @PostMapping("/selectAll")
    public JSONObject selectAllByPageCondition(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                              String ename, Integer deptno){
        Map<String, Object> params = new HashMap<>();
        params.put("ename", ename);
        params.put("deptno", deptno);
        PageInfo emps = empService.selectAllByPageCondition(params, pageNum, pageSize);
        return ReturnUtil.returnSuccess("success",emps);
    }

    /**
     * 根据员工编号查询
     * @param empno 员工编号
     * @return
     */
    @GetMapping("/selectById/{empno}")
    public JSONObject selectById(@PathVariable Integer empno){
        Emp emp = empService.selectByPrimaryKey(empno);
        return ReturnUtil.returnSuccess("success", emp);
    }

    /**
     * 添加员工
     * @param emp 员工实体对象
     * @return
     */
    @PostMapping("/insert")
    public JSONObject insert(@RequestBody Emp emp){
        try {
            empService.insertSelective(emp);
            return ReturnUtil.returnSuccess("success");
        } catch (Exception e) {
            logger.info("添加失败",e.getMessage());
        }
        return ReturnUtil.returnError("error");
    }

    /**
     * 修改员工
     * @param emp 员工实体对象
     * @return
     */
    @PutMapping("/update")
    public JSONObject update(@RequestBody Emp emp){
        try {
            empService.updateByPrimaryKeySelective(emp);
            return ReturnUtil.returnSuccess("success");
        } catch (Exception e) {
            logger.info("修改失败",e.getMessage());
        }
        return ReturnUtil.returnError("error");
    }

    /**
     * 根据员工编号删除员工
     * @param empno 员工编号
     * @return
     */
    @DeleteMapping("/deleteById/{empno}")
    public JSONObject deleteById(@PathVariable Integer empno){
        empService.deleteByPrimaryKey(empno);
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 批量插入员工
     * @param empList 员工实体对象的集合
     * @return
     */
    @PostMapping("/insertBatch")
    public JSONObject insertBatch(@RequestBody List<Emp> empList){
        try {
            empService.insertBatch(empList);
            return ReturnUtil.returnSuccess("success");
        } catch (Exception e) {
            logger.info("insertBatch失败" + e.getMessage());
        }
        return ReturnUtil.returnError("error");
    }

    /**
     * 批量删除员工
     * @param ids 员工编号的集合
     * @return
     */
    @PostMapping("/deleteBatch")
    public JSONObject deleteBatch(@RequestBody List<Integer> ids){
        empService.deleteBatch(ids);
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 根据员工编号查询员工信息及其部门信息
     * @param empno 员工编号
     * @return
     */
    @GetMapping("/selectEmpInfoById")
    public JSONObject selectEmpInfoById(@RequestParam Integer empno){
        EmpInfo empInfo = empService.selectEmpInfoById(empno);
        return ReturnUtil.returnSuccess("success",empInfo);
    }

    /**
     * 根据部门编号查询部门信息及部门员工信息
     * @param deptno 部门编号，null查所有
     * @return
     */
    @GetMapping("/selectDeptInfoList")
    public JSONObject selectDeptInfoList(@RequestParam Integer deptno){
        List<DeptInfo> deptInfos = empService.selectDeptInfoList(deptno);
        return ReturnUtil.returnSuccess("success", deptInfos);
    }

    /**
     * 查询部门信息，部门员工数量及部门平均薪资
     * @param params deptno
     * @return
     */
    @GetMapping("/selectDeptCount")
    public JSONObject selectDeptCount(@RequestBody JSONObject params){
        Integer deptno = params.getInteger("deptno");
        List<Map<String, Object>> maps = empService.selectDeptCount(deptno);
        return ReturnUtil.returnSuccess("success", maps);
    }

    /**
     * 动态插入员工，如果员工已存在则更新，不存在则插入
     * 数据表必须有一个唯一索引才可，这里是主键empno
     * @param emp
     * @return
     */
    @PostMapping("/insertOrUpdate")
    public JSONObject insertOrUpdate(@RequestBody Emp emp){
        try {
            empService.insertOrUpdate(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.returnError("fail");
        }
        return ReturnUtil.returnSuccess("success");
    }


    /**
     * 条件插入
     * 根据员工的job插入不同的comm值
     * 当job=SALESMAN时，comm=1000，其它为null
     * @param emp
     * @return
     */
    @PostMapping("/insertByJob")
    public JSONObject insertByJob(@RequestBody Emp emp){
        try {
            empService.insertByJob(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.returnError("fail");
        }
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 根据员工编号或姓名查询员工详细信息，包含基本信息，部门信息，薪资等级信息
     * @param emp empno ename
     * @return
     */
    @GetMapping("/selectDetailByIdName")
    public JSONObject selectDetailById(@RequestBody Emp emp){
        Integer empno = emp.getEmpno();
        String ename = emp.getEname();
        if (empno == null && ename == null){
            return ReturnUtil.returnError("参数为空");
        }
        EmpDetail empDetail = empService.selectDetailByIdName(emp);
        return ReturnUtil.returnSuccess("success", empDetail);
    }


}
