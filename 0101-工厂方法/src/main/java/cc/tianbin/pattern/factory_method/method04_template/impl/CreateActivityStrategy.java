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
public class CreateActivityStrategy extends AbstractStockOpStrategy {

    @Override
    public Integer getOpType() {
        return StockOpType.CREATE_ACTIVITY.getCode();
    }

    @Override
    public StockOpRes updateSkuStock() {
        log.info("OrderCreateStrategy: 创建活动 减可售");
        return StockOpRes.buildSuccessRes();
    }

    @Override
    public StockOpRes updateSkuIsolateStock() {
        log.info("OrderCreateStrategy: 创建活动 加活动隔离");
        return StockOpRes.buildSuccessRes();
    }

    @Override
    public StockOpRes updateSkuGroupStock() {
        log.info("OrderCreateStrategy: 创建活动 无子品库存变更");
        return StockOpRes.buildSuccessRes();
    }
}
