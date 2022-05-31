package cc.tianbin.pattern.strategy.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by nibnait on 2022/05/31
 */
@Getter
@AllArgsConstructor
public enum ItemsType {

    LAST_REWARD(1, "一番赏"),
    LUCKY_BAT(2, "福袋"),
    MAGIC_REWARD(3, "魔力赏"),
    NORMAL(4, "普通商品"),
    ;

    private final Integer code;
    private final String description;

    public static ItemsType getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (ItemsType value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }

        throw new IllegalArgumentException(String.format("%s 非法的商品类型", code));
    }
}
