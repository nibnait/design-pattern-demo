package cc.tianbin.pattern.factory_method.method04_template.impl;

import cc.tianbin.pattern.factory_method.method04_template.AbstractStockOpStrategy;
import cc.tianbin.pattern.factory_method.method04_template.bo.StockOpRes;
import cc.tianbin.pattern.factory_method.method04_template.bo.enums.StockOpType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by nibnait on 2022/05/31
 */
@Component
@Slf4j
public class CombineSkuStrategy extends AbstractStockOpStrategy {

    @Override
    public Integer getOpType() {
        return StockOpType.COMBINE_SKU.getCode();
    }

    @Override
    public StockOpRes updateSkuStock() {
        log.info("CombineSkuStrategy: 创建组合商品 减冻结，加待下发冻结");
        return StockOpRes.buildSuccessRes();
    }

    @Override
    public StockOpRes updateSkuIsolateStock() {
        log.info("CombineSkuStrategy: 创建组合商品 无隔离库存操作");
        return StockOpRes.buildSuccessRes();
    }

    @Override
    public StockOpRes updateSkuGroupStock() {
        log.info("CombineSkuStrategy: 创建组合商品 加子品隔离库存");
        return StockOpRes.buildSuccessRes();
    }
}
