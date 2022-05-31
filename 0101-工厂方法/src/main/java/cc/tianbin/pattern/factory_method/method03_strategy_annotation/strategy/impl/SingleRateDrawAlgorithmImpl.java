package cc.tianbin.pattern.factory_method.method03_strategy_annotation.strategy.impl;

import cc.tianbin.pattern.factory_method.method03_strategy_annotation.bo.annotation.Strategy;
import cc.tianbin.pattern.factory_method.method03_strategy_annotation.bo.enums.DrawStrategy;
import cc.tianbin.pattern.factory_method.method03_strategy_annotation.strategy.DrawAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by nibnait on 2022/05/31
 */
@Component
@Strategy(strategyMode = DrawStrategy.SINGLE)
@Slf4j
public class SingleRateDrawAlgorithmImpl implements DrawAlgorithm {

    @Override
    public String randomDraw() {

        log.info("执行【单项概率】抽奖算法");

        return "123";
    }
}
