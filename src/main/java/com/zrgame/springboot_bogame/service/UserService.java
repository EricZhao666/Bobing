package com.zrgame.springboot_bogame.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrgame.springboot_bogame.entity.User;
import com.zrgame.springboot_bogame.mappers.UserMapper;
import com.zrgame.springboot_bogame.util.ResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;


    public List findAllUser(){
        List<User> list= userMapper.selectList(null);
        return list;
    }

    public List<User> findByName(String name){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        List<User> list = userMapper.selectList(wrapper);
        return list;
    }

    public void update(String name){
        User user = new User();
        user.setName(name);
        user.setYixiu(0);
        user.setErju(0);
        user.setSanhong(0);
        user.setSijin(0);
        user.setStraight6(0);
        user.setRedotfour(0);
        user.setBlackdot5(0);
        user.setRedotfive(0);
        user.setBlackdot6(0);
        user.setBlossomone(0);
        user.setAllaroundsix(0);
        user.setIcing(0);
        user.setBlank(0);
        userMapper.updateById(user);
    }


}
