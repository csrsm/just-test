package com.newbee.controller;


import com.newbee.Service.UserInfoService;
import com.newbee.controller.request.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(value = "用户信息管理控制器")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "接口：新增用户信息" ,httpMethod = "POST")
    @PostMapping(value = "/saveUser")
    public Object saveUser (@RequestBody User user){
        return userInfoService.saveUser(user);
    }

    @ApiOperation(value = "接口：修改用户信息" ,httpMethod = "POST")
    @PostMapping(value = "/updateUser")
    public Object updateUser (@RequestBody User user){
        return userInfoService.updateUser(user);
    }

    @ApiOperation(value = "接口：根据ID查询用户信息",httpMethod = "POST")
    @PostMapping("/queryUser")
    public Object get(@RequestBody User user){
        return userInfoService.getUserDetail(user.getId());
    }

    @ApiOperation(value = "接口：删除用户")
    @DeleteMapping("/deleteUser/{id}")
    public Object deleteUser(@PathVariable Long id){
        return userInfoService.deleteUser(id);
    }



}
