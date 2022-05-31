package cc.tianbin.pattern.factory_method.method04_template.bo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by nibnait on 2022/05/31
 */
@Getter
@AllArgsConstructor
public enum StockErrorCode {

    SUCCESS(0L, "成功"),
    FAIL(1L, "失败"),
    ;

    private final Long code;
    private final String msg;

}
