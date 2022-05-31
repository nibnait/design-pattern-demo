package cc.tianbin.pattern.factory_method.method01_config_map.impl;

import cc.tianbin.pattern.factory_method.method01_config_map.OpenTailMoneyValidator;
import cc.tianbin.pattern.factory_method.method01_config_map.bo.OpenTailMoneyCheckBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by nibnait on 2022/05/31
 */
@Component
@Slf4j
public class TaoOpenTailMoneyValidator extends OpenTailMoneyValidator {

    public void validate(OpenTailMoneyCheckBO openTailMoneyCheckBO) {
        log.info("仅淘系 校验开补款 通过");
    }

}
