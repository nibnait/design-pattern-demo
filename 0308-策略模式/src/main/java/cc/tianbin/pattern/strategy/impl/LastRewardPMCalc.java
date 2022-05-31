package cc.tianbin.pattern.strategy.impl;

import cc.tianbin.pattern.strategy.ProfitMarginCalc;
import cc.tianbin.pattern.strategy.bo.ItemsSku;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Created by nibnait on 2022/05/31
 */
@Slf4j
public class LastRewardPMCalc extends ProfitMarginCalc {

    public LastRewardPMCalc(ItemsSku itemsSku) {
        setItemsSku(itemsSku);
    }

    @Override
    public BigDecimal calc() {
        BigDecimal pmRate = BigDecimal.valueOf(1.1);

        log.info("计算一番赏利润率: {}", pmRate);

        return pmRate;
    }
}
