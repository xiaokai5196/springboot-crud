package com.dict.emp;

import com.dict.emp.entity.DeptEmps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCrudApplicationTest {

    @Autowired
    private DeptEmps deptEmps;

    @Test
    public void dpet(){
        System.out.println(deptEmps);
    }

    @Test
    public void contextLoads() {
        Logger logger = LoggerFactory.getLogger(SpringbootCrudApplicationTest.class);
        logger.trace("trace级别log");
        logger.debug("debug级别log");
        logger.info("info级别log");
        logger.warn("warn级别log");
        logger.error("error级别log");
    }
}