package com.dict.emp.mapper;

import com.dict.emp.entity.Dept;
import com.dict.emp.entity.vo.DeptInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DeptMapper {

    int deleteByPrimaryKey(Integer deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> selectDeptList();

    List<DeptInfo> selectDeptInfo(Integer deptno);
}