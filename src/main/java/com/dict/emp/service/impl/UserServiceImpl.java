package com.dict.emp.service.impl;

import com.dict.emp.entity.User;
import com.dict.emp.mapper.UserMapper;
import com.dict.emp.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> selectUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectUserList();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    @Override
    public User selectById(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int batchInsert(List<User> userList) {
        return userMapper.batchInsert(userList);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int batchUpdate(List<User> userList) {
        for (int i = 0, length = userList.size(); i < length; i++) {
            update(userList.get(i));
        }
        return 0;
    }

    @Override
    public int deleteById(Long userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        return userMapper.batchDelete(ids);
    }
}
