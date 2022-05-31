package cc.tianbin.pattern.factory_method.method04_template.bo;

import lombok.Data;

/**
 * Created by nibnait on 2022/05/31
 */
@Data
public class StockOpReq {

    private Integer opType;

    public StockOpReq(Integer opType) {
        this.opType = opType;
    }
}
