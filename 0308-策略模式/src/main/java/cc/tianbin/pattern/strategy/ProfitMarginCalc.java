package cc.tianbin.pattern.strategy;

import cc.tianbin.pattern.strategy.bo.ItemsSku;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by nibnait on 2022/05/31
 */
@Data
public abstract class ProfitMarginCalc {

    private ItemsSku itemsSku;

    public abstract BigDecimal calc();

}
