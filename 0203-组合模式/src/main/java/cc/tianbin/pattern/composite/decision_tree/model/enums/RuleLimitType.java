package cc.tianbin.pattern.composite.decision_tree.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by nibnait on 2022/06/01
 */
@Getter
@AllArgsConstructor
public enum RuleLimitType {

    EQUAL(1, "等于"),
    GT(2, "大于"),
    LT(3, "小于"),
    GTE(4, "大于等于"),
    LTE(5, "小于等于"),
    ENUM(6, "枚举"),
    ;

    private final Integer code;
    private final String description;

}
