package com.dict.emp.service;

import com.dict.emp.entity.vo.DeptInfo;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpDetail;
import com.dict.emp.entity.vo.EmpInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface EmpService {

    int deleteByPrimaryKey(Integer empno);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Emp record);

    List<Emp> selectEmpList();

    PageInfo selectAllByPageCondition(Map<String,Object> params, Integer pageNum, Integer pageSize);

    int insertBatch(List<Emp> empList);

    int deleteBatch(List<Integer> ids);

    EmpInfo selectEmpInfoById(Integer empno);

    List<DeptInfo> selectDeptInfoList(Integer deptno);

    List<Map<String, Object>> selectDeptCount(Integer deptno);

    int insertOrUpdate(Emp emp);

    int insertByJob(Emp emp);

    EmpDetail selectDetailByIdName(Emp emp);




}
