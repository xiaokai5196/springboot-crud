package com.dict.emp.service.impl;

import com.dict.emp.entity.Dept;
import com.dict.emp.entity.vo.DeptInfo;
import com.dict.emp.mapper.DeptMapper;
import com.dict.emp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Integer deptno) {
        return deptMapper.deleteByPrimaryKey(deptno);
    }

    @Override
    public int insert(Dept record) {
        return deptMapper.insert(record);
    }

    @Override
    public int insertSelective(Dept record) {
        return deptMapper.insertSelective(record);
    }

    @Override
    public Dept selectByPrimaryKey(Integer deptno) {
        return deptMapper.selectByPrimaryKey(deptno);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return deptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return deptMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Dept> selectDeptList() {
        return deptMapper.selectDeptList();
    }

    @Override
    public List<DeptInfo> selectDeptInfo(Integer deptno) {
        return deptMapper.selectDeptInfo(deptno);
    }
}
