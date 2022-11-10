package com.zrgame.springboot_bogame;

import com.zrgame.springboot_bogame.config.RuleConfig;
import com.zrgame.springboot_bogame.entity.GameResult;
import com.zrgame.springboot_bogame.entity.PrizeEnum;
import com.zrgame.springboot_bogame.service.GameService;
import com.zrgame.springboot_bogame.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.zrgame.springboot_bogame.util.RandomUtil;

import javax.annotation.Resource;
import java.util.regex.Pattern;

@SpringBootTest
class SpringbootBoGameApplicationTests {

    @Resource
    GameService gameService;


    @Test
    void contextLoads() {
    }

    @Test
    public void testRule() {
            System.out.println(Pattern.matches(RuleConfig.FIVERED, "444445"));
    }

    @Test
    public void testnumber(){
        String s="333334";
        System.out.println(testResult(s));
    }
    public static GameResult testResult(String s){
        if (Pattern.matches(RuleConfig.FLOWERPATTERN, s)) {
            return new GameResult(PrizeEnum.FLOWER.getDesc(),s);//状元插金花
        }
        else if (Pattern.matches(RuleConfig.SIXREDPATTERN, s)) {
            return new GameResult(PrizeEnum.SIXFIVE.getDesc(),s);//六杯红
        }
        else if (Pattern.matches(RuleConfig.BIANDIPATTERN, s)) {
            return new GameResult(PrizeEnum.SIXONE.getDesc(),s);//遍地锦
        }
        else if (Pattern.matches(RuleConfig.LIUHEIPATTERN, s)) {
            return new GameResult(PrizeEnum.SIXBLACK.getDesc(),s);//六博黑
        }
        else if (Pattern.matches(RuleConfig.FIVERED, s)) {
            return new GameResult(PrizeEnum.FIVERED.getDesc(),s);//五红
        }
        else if (Pattern.matches(RuleConfig.FIVEPATTERN, s)) {
            return new GameResult(PrizeEnum.FIVE.getDesc(),s);//五子登科
        }
        else if (Pattern.matches(RuleConfig.CHIEFPATTERN, s)) {
            return new GameResult(PrizeEnum.CHIEF.getDesc(),s);//状元
        }
        else if (Pattern.matches(RuleConfig.PAIRPATTERN, s)) {
            return new GameResult(PrizeEnum.PAIR.getDesc(),s);//对堂
        }
        else if (Pattern.matches(RuleConfig.REDPATTERN, s)) {
            return new GameResult(PrizeEnum.RED.getDesc(),s);//三红
        }
        else if (Pattern.matches(RuleConfig.ENTERPATTERN, s)) {
            return new GameResult(PrizeEnum.ENTER.getDesc(),s);//四进
        }
        else if (Pattern.matches(RuleConfig.LIFTPATTERN, s)) {
            return new GameResult(PrizeEnum.LIFT.getDesc(),s);//二举
        }
        else if (Pattern.matches(RuleConfig.SHOWPATTERN, s)) {
            return new GameResult(PrizeEnum.SHOW.getDesc(),s);//一秀
        }
        else{
            return new GameResult(PrizeEnum.BLANK.getDesc(),s);//无
        }
    }
}
