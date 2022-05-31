package cc.tianbin.pattern.factory_method.method03_strategy.strategy.impl;

import cc.tianbin.pattern.factory_method.method03_strategy.bo.Strategy;
import cc.tianbin.pattern.factory_method.method03_strategy.bo.DrawStrategy;
import cc.tianbin.pattern.factory_method.method03_strategy.strategy.DrawAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by nibnait on 2022/05/31
 */
@Component
@Strategy(strategyMode = DrawStrategy.ENTIRETY)
@Slf4j
public class EntiretyRateDrawAlgorithmImpl implements DrawAlgorithm {

    @Override
    public String randomDraw() {

        log.info("执行【总体概率】抽奖算法");

        return "456";
    }
}
