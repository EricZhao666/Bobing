package com.zrgame.springboot_bogame.controller;


import com.zrgame.springboot_bogame.entity.User;
import com.zrgame.springboot_bogame.service.UserService;
import com.zrgame.springboot_bogame.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/user")
@Api
public class UserController {

    @Resource
    UserService userService;


    @ApiOperation("获取多个人结果")
    @RequestMapping(value = "/numberresult", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult getNumber(@RequestParam("number")int number){
        List<User> AllList = new LinkedList<>();;
        for (int i = 1; i <=number ; i++) {
            String name=String.valueOf(i);
            List<User> list=userService.findByName(name);
            AllList.addAll(list);
        }
        return new ResponseResult(200,"查询完成",AllList);
    }

    @ApiOperation("获取单个人结果")
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult findone(@RequestParam("name")String name){
        List list=userService.findByName(name);
        return new ResponseResult(200,"查询完成",list);
    }

    @ApiOperation("获取所有人结果")
    @RequestMapping(value = "/alluser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getAllUser(){
        List<User> list=userService.findAllUser();
        return new ResponseResult(200,"查询完成",list);
    }

    @ApiOperation("清除获奖数据")
    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult clearall(){
        for (int i = 1; i <=8; i++) {
            String name=String.valueOf(i);
            userService.update(name);
        }
        return new ResponseResult(200,"初始化完成");
    }


}
