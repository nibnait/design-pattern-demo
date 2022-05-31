package cc.tianbin.pattern.factory_method.method01_config_map.bo;

import lombok.Data;

/**
 * Created by nibnait on 2022/05/31
 */
@Data
public class OpenTailMoneyCheckBO {

    /**
     * 开补款渠道 1仅自营 2仅淘系 3自营+淘系
     */
    private Integer channel;

    /**
     * 商品当前剩余库存
     */
    private Integer stock;

    /**
     * 自营 待履约库存
     */
    private Integer biliStock;

    /**
     * 淘系 待履约库存
     */
    private Integer taoStock;

    public OpenTailMoneyCheckBO(Integer channel) {
        this.channel = channel;
    }

    public static OpenTailMoneyCheckBO buildBiliChannel() {
        return new OpenTailMoneyCheckBO(Channel.BILI.getCode());
    }

    public static OpenTailMoneyCheckBO buildTaoChannel() {
        return new OpenTailMoneyCheckBO(Channel.TAO.getCode());
    }

    public static OpenTailMoneyCheckBO buildBiliTaoChannel() {
        return new OpenTailMoneyCheckBO(Channel.BILI_TAO.getCode());
    }
}
