package cc.tianbin.pattern.factory_method.method04_template;

import cc.tianbin.pattern.factory_method.method04_template.bo.enums.StockErrorCode;
import cc.tianbin.pattern.factory_method.method04_template.bo.StockOpRes;

/**
 * Created by nibnait on 2022/05/31
 */
public abstract class AbstractStockOpStrategy {

    public StockOpRes execute() {
        StockOpRes stockOpRes = updateSkuStock();
        if (fail(stockOpRes)) {
            return stockOpRes;
        }

        stockOpRes = updateSkuIsolateStock();
        if (fail(stockOpRes)) {
            return stockOpRes;
        }

        stockOpRes = updateSkuGroupStock();
        if (fail(stockOpRes)) {
            return stockOpRes;
        }

        return StockOpRes.buildByErrorCode(StockErrorCode.SUCCESS);
    }

    private boolean fail(StockOpRes stockOpRes) {
        return stockOpRes == null || StockErrorCode.FAIL.getCode().equals(stockOpRes.getCode());
    }

    public abstract Integer getOpType();

    public abstract StockOpRes updateSkuStock();

    public abstract StockOpRes updateSkuIsolateStock();

    public abstract StockOpRes updateSkuGroupStock();

}
