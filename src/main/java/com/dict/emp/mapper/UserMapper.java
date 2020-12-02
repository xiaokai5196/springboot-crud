package com.dict.emp.mapper;

import com.dict.emp.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectUserList();

    User selectById(Long userId);

    int insert(User user);

    int batchInsert(List<User> userList);

    int update(User user);

    int deleteById(Long userId);

    int batchDelete(List<Long> ids);


}
