package cc.tianbin.pattern.factory_method.method03_strategy_annotation.bo.enums;

/**
 * Created by nibnait on 2022/05/31
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 抽奖策略模式：总体概率、单项概率
 * 场景：两种抽奖算法描述，场景A20%、B30%、C50%
 * 单项概率：如果A奖品抽空后，B和C保持目前中奖概率，用户抽奖扔有20%中为A，因A库存抽空则结果展示为未中奖。为了运营成本，通常这种情况的使用的比较多
 * 总体概率：如果A奖品抽空后，B和C奖品的概率按照 3:5 均分，相当于B奖品中奖概率由 0.3 升为 0.375
 */
@Getter
@AllArgsConstructor
public enum DrawStrategy {

    SINGLE(1, "单项概率"),
    ENTIRETY(2, "总体概率"),
    ;

    private final Integer code;
    private final String info;

    public static DrawStrategy getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (DrawStrategy value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }

        throw new IllegalArgumentException(String.format("%s 非法的抽奖策略类型", code));
    }
}
