package cc.tianbin.pattern.factory_method.method04_template.bo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by nibnait on 2022/05/31
 */
@Getter
@AllArgsConstructor
public enum StockOpType {

    CREATE_ORDER(1, "下单"),
    CREATE_ACTIVITY(2, "创建活动"),
    COMBINE_SKU(3, "创建组合商品"),
    ;

    private final Integer code;
    private final String description;

}
