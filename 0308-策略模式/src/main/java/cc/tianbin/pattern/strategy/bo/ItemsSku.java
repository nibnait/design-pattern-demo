package cc.tianbin.pattern.strategy.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by nibnait on 2022/05/31
 */
@Data
@AllArgsConstructor
public class ItemsSku {

    /**
     * sku 类型
     */
    private Integer type;

    /**
     * 利润率
     */
    private BigDecimal pmRate;

    public ItemsSku(Integer type) {
        this.type = type;
    }
}
