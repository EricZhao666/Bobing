package com.zrgame.springboot_bogame.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrgame.springboot_bogame.entity.GameResult;
import com.zrgame.springboot_bogame.entity.PrizeEnum;
import com.zrgame.springboot_bogame.config.RuleConfig;
import com.zrgame.springboot_bogame.entity.User;
import com.zrgame.springboot_bogame.mappers.UserMapper;
import com.zrgame.springboot_bogame.util.RandomUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.regex.Pattern;

@Service
public class GameService {

    @Resource
    UserMapper userMapper;

    public GameResult GetResult(){
        String[] s1= RandomUtil.buildRandomStr(6);
        String s_unsort=s1[0];
        String s=s1[1];
        if (Pattern.matches(RuleConfig.FLOWERPATTERN, s)) {
            return new GameResult(PrizeEnum.FLOWER.getDesc(),s_unsort,s);//状元插金花
        }
        else if (Pattern.matches(RuleConfig.SIXREDPATTERN, s)) {
            return new GameResult(PrizeEnum.SIXFIVE.getDesc(),s_unsort,s);//六杯红
        }
        else if (Pattern.matches(RuleConfig.BIANDIPATTERN, s)) {
            return new GameResult(PrizeEnum.SIXONE.getDesc(),s_unsort,s);//遍地锦
        }
        else if (Pattern.matches(RuleConfig.LIUHEIPATTERN, s)) {
            return new GameResult(PrizeEnum.SIXBLACK.getDesc(),s_unsort,s);//六博黑
        }
        else if (Pattern.matches(RuleConfig.FIVERED, s)) {
            return new GameResult(PrizeEnum.FIVERED.getDesc(),s_unsort,s);//五红
        }
        else if (Pattern.matches(RuleConfig.FIVEPATTERN, s)) {
            return new GameResult(PrizeEnum.FIVE.getDesc(),s_unsort,s);//五子登科
        }
        else if (Pattern.matches(RuleConfig.CHIEFPATTERN, s)) {
            return new GameResult(PrizeEnum.CHIEF.getDesc(),s_unsort,s);//状元
        }
        else if (Pattern.matches(RuleConfig.PAIRPATTERN, s)) {
            return new GameResult(PrizeEnum.PAIR.getDesc(),s_unsort,s);//对堂
        }
        else if (Pattern.matches(RuleConfig.REDPATTERN, s)) {
            return new GameResult(PrizeEnum.RED.getDesc(),s_unsort,s);//三红
        }
        else if (Pattern.matches(RuleConfig.ENTERPATTERN, s)) {
            return new GameResult(PrizeEnum.ENTER.getDesc(),s_unsort,s);//四进
        }
        else if (Pattern.matches(RuleConfig.LIFTPATTERN, s)) {
            return new GameResult(PrizeEnum.LIFT.getDesc(),s_unsort,s);//二举
        }
        else if (Pattern.matches(RuleConfig.SHOWPATTERN, s)) {
            return new GameResult(PrizeEnum.SHOW.getDesc(),s_unsort,s);//一秀
        }
        else{
            return new GameResult(PrizeEnum.BLANK.getDesc(),s_unsort,s);//无
        }
    }

    public User dataTra(GameResult gameResult,String username){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", username);
        User user=userMapper.selectOne(wrapper);
        String name=gameResult.getResultName();
        if (name.equals("yixiu")){
            int point=user.getYixiu();
            user.setYixiu(point+1);
        }
        else if (name.equals("erju")) {
            int point=user.getErju();
            user.setErju(point+1);
        }
        else if (name.equals("sijin")) {
            int point=user.getSijin();
            user.setSijin(point+1);
        }
        else if (name.equals("sanhong")) {
            int point=user.getSanhong();
            user.setSanhong(point+1);
        }
        else if (name.equals("straight6")) {
            int point=user.getStraight6();
            user.setStraight6(point+1);
        }
        else if (name.equals("redotfour")) {
            int point=user.getRedotfour();
            user.setRedotfour(point+1);
        }
        else if (name.equals("blackdot5")) {
            int point=user.getBlackdot5();
            user.setBlackdot5(point+1);
        }
        else if (name.equals("redotfive")) {
            int point=user.getRedotfive();
            user.setRedotfive(point+1);
        }
        else if (name.equals("blackdot6")) {
            int point=user.getBlackdot6();
            user.setBlackdot6(point+1);
        }
        else if (name.equals("blossomone")) {
            int point=user.getBlossomone();
            user.setBlossomone(point+1);
        }
        else if (name.equals("allaroundsix")) {
            int point=user.getAllaroundsix();
            user.setAllaroundsix(point+1);
        }
        else if (name.equals("icing")) {
            int point=user.getIcing();
            user.setIcing(point+1);
        }
        return user;
    }

}
