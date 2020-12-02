package com.dict.emp.service;

import com.dict.emp.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    PageInfo<User> selectUserList(int pageNum, int pageSize);

    User selectById(Long userId);

    int insert(User user);

    int batchInsert(List<User> userList);

    int update(User user);

    int batchUpdate(List<User> userList);

    int deleteById(Long userId);

    int batchDelete(List<Long> ids);
}
