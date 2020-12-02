package com.dict.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.common.ReturnUtil;
import com.dict.emp.entity.User;
import com.dict.emp.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询所有用户
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return
     */
    @GetMapping("/selectUserList")
    public JSONObject selectUserList(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        PageInfo<User> userPageInfo = userService.selectUserList(pageNum, pageSize);
        return ReturnUtil.returnSuccess("success", userPageInfo);
    }

    /**
     * 根据id查询用户
     * @param userId 用户id
     * @return
     */
    @GetMapping("/selectById/{id}")
    public JSONObject selectById(@PathVariable("id") Long userId ){
        User user = userService.selectById(userId);
        return ReturnUtil.returnSuccess("success", user);
    }

    /**
     * 添加用户
     * @param user 用户对象
     * @return
     */
    @PostMapping("insert")
    public JSONObject insert(@RequestBody User user){
        userService.insert(user);
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 批量添加用户
     * @param userList 用户集合
     * @return
     */
    @PostMapping("/batchInsert")
    public JSONObject batchInsert(@RequestBody List<User> userList){
        if (userList == null || userList.size() == 0){
            return ReturnUtil.returnError("参数为空");
        }
        userService.batchInsert(userList);
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 更新用户
     * @param user 用户对象
     * @return
     */
    @PutMapping("/update")
    public JSONObject update(@RequestBody User user){
        userService.update(user);
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 批量更新用户
     * @param userList 用户集合
     * @return
     */
    @PutMapping("/batchUpdate")
    public JSONObject batchUpdate(@RequestBody List<User> userList){
        if (userList == null || userList.size() == 0){
            return ReturnUtil.returnError("参数为空");
        }
        userService.batchUpdate(userList);
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 根据id删除用户
     * @param userId 用户id
     * @return
     */
    @DeleteMapping("/deleteById/{userId}")
    public JSONObject deleteById(@PathVariable Long userId){
        userService.deleteById(userId);
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 根据id批量删除用户
     * @param ids 用户id的集合
     * @return
     */
    @DeleteMapping("/batchDelete")
    public JSONObject batchDelete(@RequestBody List<Long> ids){
        if (ids == null || ids.size() == 0){
            return ReturnUtil.returnError("参数为空");
        }
        userService.batchDelete(ids);
        return ReturnUtil.returnSuccess("success");
    }





}
