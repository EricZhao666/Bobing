package com.zrgame.springboot_bogame.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrgame.springboot_bogame.entity.GameResult;
import com.zrgame.springboot_bogame.entity.PrizeEnum;
import com.zrgame.springboot_bogame.entity.User;
import com.zrgame.springboot_bogame.mappers.UserMapper;
import com.zrgame.springboot_bogame.service.GameService;
import com.zrgame.springboot_bogame.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/game")
@Api
public class GameController {

    @Resource
    GameService gameService;

    @Resource
    UserMapper userMapper;


    @ApiOperation("获取博饼结果")
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult GameResult(@RequestParam("name")String name){
        GameResult result= gameService.GetResult();
        User user=gameService.dataTra(result,name);
        userMapper.updateById(user);
        return new ResponseResult(200,"博饼结果",result);
    }
}
