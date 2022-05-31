package cc.tianbin.pattern.factory_method.method03_strategy.strategy;

/**
 * Created by nibnait on 2022/05/31
 */
public interface DrawAlgorithm {

    /**
     * 抽奖算法，返回奖品id
     */
    String randomDraw();

}
