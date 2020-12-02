package com.dict.emp.mapper;

import com.dict.emp.entity.vo.DeptInfo;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpDetail;
import com.dict.emp.entity.vo.EmpInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    //根据主键删除
    int deleteByPrimaryKey(Integer empno);

    //插入，插入全部属性
    int insert(Emp record);

    //动态插入
    int insertSelective(Emp record);

    //根据主键查询
    Emp selectByPrimaryKey(Integer empno);

    //动态更新，只更新变更的字段，其他值不变
    int updateByPrimaryKeySelective(Emp record);

    //全部更新，如果只传部分字段属性的值，其它字段会被更新为null
    int updateByPrimaryKey(Emp record);

    //查询全部员工
    List<Emp> selectEmpList();

    //分页+条件查询员工
    List<Emp> selectAllByPageCondition(Map<String,Object> params);

    //批量添加
    int insertBatch(List<Emp> empList);

    //批量删除
    int deleteBatch(List<Integer> ids);

    //查询某个员工信息及其部门信息
    EmpInfo selectEmpInfoById(Integer empno);
    //查询某个员工信息及其部门信息 方法2-分步查询
    EmpInfo selectEmpInfoByIdStep(Integer empno);

    //查询所有部门及每个部门下的所有员工
    List<DeptInfo> selectDeptInfoList(Integer deptno);
    //分步查询
    List<DeptInfo> selectDeptInfoListStep(Integer deptno);

    //根据部门编号查员工列表
    List<Emp> selectEmpListByDeptno(Integer deptno);

    List<Map<String, Object>> selectDeptCount(Integer deptno);

    int insertOrUpdate(Emp emp);

    int insertByJob(Emp emp);

    EmpDetail selectDetailByIdName(Emp emp);



}