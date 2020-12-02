package com.dict.emp.mapper;

import com.dict.emp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectTest01() {
        User user = userMapper.selectTest01(1L);
        System.out.println(user);
    }

    @Test
    public void selectTest02() {
        List<User> list = userMapper.selectTest02(1L, "wangwu");
        System.out.println(list);
    }

    @Test
    public void selectTest03() {
        User user = new User();
        user.setId(1L);
        user.setName("lisi");
        List<User> list = userMapper.selectTest03(user);
        System.out.println(list);
    }

    @Test
    public void selectTest04() {
        User user = new User();
        user.setId(1L);
        user.setName("lisi");
        List<User> list = userMapper.selectTest04(1, 2, user);
        System.out.println(list);
    }

    @Test
    public void selectTest05() {
        List<User> list = userMapper.selectTest05("user", "id");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void selectTest06() {
        List<User> list = userMapper.selectTest06(Arrays.asList(1L, 2L, 3L));
        for (User user : list) {
            System.out.println(user);
        }
    }


    @Test
    public void insertBatch() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setName("testname-" + i);
            user.setAge(20 + i);
            user.setAddr("changsha-" + i);
            users.add(user);
        }
        System.out.println(users);
        int i = userMapper.insertBatch(users);
        System.out.println("共插入了：" + i + "条数据");
    }


}