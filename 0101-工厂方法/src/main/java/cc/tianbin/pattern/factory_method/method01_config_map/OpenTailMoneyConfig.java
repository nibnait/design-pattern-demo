package cc.tianbin.pattern.factory_method.method01_config_map;

import cc.tianbin.pattern.factory_method.method01_config_map.bo.Channel;
import cc.tianbin.pattern.factory_method.method01_config_map.impl.BiliOpenTailMoneyValidator;
import cc.tianbin.pattern.factory_method.method01_config_map.impl.BiliTaoOpenTailMoneyValidator;
import cc.tianbin.pattern.factory_method.method01_config_map.impl.TaoOpenTailMoneyValidator;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nibnait on 2022/05/31
 */
public class OpenTailMoneyConfig {

    private static final Map<Channel, OpenTailMoneyValidator> map = new HashMap(3);

    @Resource
    private BiliOpenTailMoneyValidator biliOpenTailMoneyValidator;
    @Resource
    private TaoOpenTailMoneyValidator taoOpenTailMoneyValidator;
    @Resource
    private BiliTaoOpenTailMoneyValidator biliTaoOpenTailMoneyValidator;

    @PostConstruct
    public void init() {
        map.put(Channel.BILI, biliOpenTailMoneyValidator);
        map.put(Channel.TAO, taoOpenTailMoneyValidator);
        map.put(Channel.BILI_TAO, biliTaoOpenTailMoneyValidator);
    }

    /**
     * 这个 map 可以理解为 开补款校验的工厂。
     * 根据 channel 返回不同的校验器
     */
    public static OpenTailMoneyValidator getOpenTailMoneyValidator(Integer code) {
        Channel channel = Channel.getByCode(code);
        return map.get(channel);
    }
}
