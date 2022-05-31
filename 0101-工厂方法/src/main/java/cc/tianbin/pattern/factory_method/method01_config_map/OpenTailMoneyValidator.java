package cc.tianbin.pattern.factory_method.method01_config_map;

import cc.tianbin.pattern.factory_method.method01_config_map.bo.OpenTailMoneyCheckBO;
import org.springframework.stereotype.Component;

/**
 * Created by nibnait on 2022/05/31
 */
@Component
public class OpenTailMoneyValidator extends OpenTailMoneyConfig {

    public void check(OpenTailMoneyCheckBO openTailMoneyCheckBO) {
        getOpenTailMoneyValidator(openTailMoneyCheckBO.getChannel()).validate(openTailMoneyCheckBO);
    }

    protected void validate(OpenTailMoneyCheckBO openTailMoneyCheckBO) {
        throw new UnsupportedOperationException("无法在此校验开补款");
    }
}
