package cc.tianbin.pattern.factory_method.method04_template.bo;

import cc.tianbin.pattern.factory_method.method04_template.bo.enums.StockErrorCode;
import lombok.Data;

/**
 * Created by nibnait on 2022/05/31
 */
@Data
public class StockOpRes {

    private Long code;

    private String msg;

    public static StockOpRes buildByErrorCode(StockErrorCode stockErrorCode) {
        StockOpRes stockOpRes = new StockOpRes();
        stockOpRes.setCode(stockErrorCode.getCode());
        stockOpRes.setMsg(stockOpRes.getMsg());
        return stockOpRes;
    }

    public static StockOpRes buildSuccessRes() {
        return buildByErrorCode(StockErrorCode.SUCCESS);
    }
}
