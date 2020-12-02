package com.dict.emp.mapper;

import com.dict.emp.entity.Salgrade;
import org.apache.ibatis.annotations.*;

public interface SalgradeMapper {

    @Select("select * from salgrade where grade=#{grade}")
    Salgrade selectById(@Param("grade") Integer grade);


}