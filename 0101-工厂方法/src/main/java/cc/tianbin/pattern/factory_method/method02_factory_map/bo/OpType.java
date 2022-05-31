package cc.tianbin.pattern.factory_method.method02_factory_map.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by nibnait on 2022/05/31
 */
@Getter
@AllArgsConstructor
public enum OpType {

    AUDIT_PASS(1, "审核通过"),
    AUDIT_REJECT(2, "审核驳回"),
    SPECIAL_PASS(3, "特批通过"),
    ;

    private final Integer code;
    private final String description;

}
