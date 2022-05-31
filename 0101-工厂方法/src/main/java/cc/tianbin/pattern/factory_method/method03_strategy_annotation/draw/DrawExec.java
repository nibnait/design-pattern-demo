package cc.tianbin.pattern.factory_method.method03_strategy_annotation.draw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by nibnait on 2022/05/31
 */
@Component
@Slf4j
public class DrawExec extends DrawConfig {

    public String doDrawExec(Integer drawStrategy) {
        // 初始化奖池

        // 抽奖
        String rewardId = getDrawAlgorithm(drawStrategy).randomDraw();

        // 构造返回值
        return rewardId;
    }

}
