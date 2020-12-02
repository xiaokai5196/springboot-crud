package com.dict.emp.service.impl;

import com.dict.emp.common.RedisUtil;
import com.dict.emp.entity.vo.DeptInfo;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpDetail;
import com.dict.emp.entity.vo.EmpInfo;
import com.dict.emp.mapper.EmpMapper;
import com.dict.emp.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int deleteByPrimaryKey(Integer empno) {
        //先执行删除，再使缓存失效
        int i = empMapper.deleteByPrimaryKey(empno);
        redisUtil.del("emp_" + empno, "empList");
        return i;
    }

    @Override
    public int insertSelective(Emp record) {
        int i = empMapper.insertSelective(record);
        redisUtil.del( "empList");
        return i;
    }

    @Override
    public Emp selectByPrimaryKey(Integer empno) {
        //先去redis中去查询是否有缓存
        Emp emp = (Emp) redisUtil.get("emp_" + empno);
        if (emp == null) {
            emp = empMapper.selectByPrimaryKey(empno);
            redisUtil.set("emp_" + empno, emp);
        }
        return emp;
    }

    @Override
    public int updateByPrimaryKeySelective(Emp record) {
        int i = empMapper.updateByPrimaryKeySelective(record);
        redisUtil.del("emp_" + record.getEmpno(), "empList");
        return i;
    }

    @Override
    public List<Emp> selectEmpList() {
        List<Emp> empList = (List<Emp>) redisUtil.get("empList");
        if (empList == null) {
            empList = empMapper.selectEmpList();
            redisUtil.set("empList", empList);
        }
        return empList;
    }

    @Override
    public PageInfo<Emp> selectAllByPageCondition(Map<String, Object> params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Emp> emps = empMapper.selectAllByPageCondition(params);
        PageInfo<Emp> pageInfo = new PageInfo(emps);
        return pageInfo;
    }

    @Override
    public int insertBatch(List<Emp> empList) {
        int i = empMapper.insertBatch(empList);
        redisUtil.del( "empList");
        return i;
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        int i = empMapper.deleteBatch(ids);
        redisUtil.del( "empList");
        return i;
    }

    @Override
    public EmpInfo selectEmpInfoById(Integer empno) {
        return empMapper.selectEmpInfoById(empno);
    }

    @Override
    public List<DeptInfo> selectDeptInfoList(Integer deptno) {
        return empMapper.selectDeptInfoList(deptno);
    }

    @Override
    public List<Map<String, Object>> selectDeptCount(Integer deptno) {
        return empMapper.selectDeptCount(deptno);
    }

    @Override
    public int insertOrUpdate(Emp emp) {
        return empMapper.insertOrUpdate(emp);
    }

    @Override
    public int insertByJob(Emp emp) {
        return empMapper.insertByJob(emp);
    }

    @Override
    public EmpDetail selectDetailByIdName(Emp emp) {
        return empMapper.selectDetailByIdName(emp);
    }
}
