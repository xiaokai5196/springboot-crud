package com.dict.emp.mapper;

import com.dict.emp.entity.vo.DeptInfo;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmpMapperTest {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void deleteByPrimaryKey() {
        int i = empMapper.deleteByPrimaryKey(1);
        System.out.println("删除了" + i + "条数据");
    }

    @Test
    public void insertSelective() {
        Emp emp = new Emp();
        emp.setEmpno(1);
        emp.setEname("zhangsan");
        int i = empMapper.insertSelective(emp);
        System.out.println("插入了" + i + "条数据");
    }

    @Test
    public void selectAllByPageCondition() {
        Map<String, Object> params = new HashMap<>();
        params.put("deptno", "20");
        List<Emp> emps = empMapper.selectAllByPageCondition(params);
        System.out.println(emps);
    }

    @Test
    public void selectEmpInfoById(){
        EmpInfo empInfo = empMapper.selectEmpInfoById(7369);
        System.out.println(empInfo);
    }

    @Test
    public void selectEmpInfoByIdStep(){
        EmpInfo empInfo = empMapper.selectEmpInfoByIdStep(7369);
        System.out.println(empInfo);
        //开启懒加载后对比，与dept无关时只发一条sql
//        System.out.println(empInfo.getEname());
    }

    @Test
    public void selectDeptInfoList(){
        List<DeptInfo> deptInfos = empMapper.selectDeptInfoList(20);
        for (DeptInfo deptInfo : deptInfos){
            System.out.println(deptInfo);
        }
    }

    @Test
    public void selectDeptInfoListStep(){
        List<DeptInfo> deptInfos = empMapper.selectDeptInfoListStep(20);
        for (DeptInfo deptInfo : deptInfos){
            System.out.println(deptInfo);
        }
    }




}