package cc.tianbin.pattern.factory_method.method01_config_map.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by nibnait on 2022/05/31
 */
@Getter
@AllArgsConstructor
public enum Channel {

    /**
     * 开补款渠道 1仅自营 2仅淘系 3自营+淘系
     */
    BILI(1, "仅自营"),
    TAO(2, "仅淘系"),
    BILI_TAO(3, "自营+淘系"),
    ;

    private final Integer code;
    private final String description;

    public static Channel getByCode(Integer code) {
        if (code == null) {
            return null;
        }

        for (Channel value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }

        throw new IllegalArgumentException(String.format("%s 非法的开补款渠道", code));
    }
}
