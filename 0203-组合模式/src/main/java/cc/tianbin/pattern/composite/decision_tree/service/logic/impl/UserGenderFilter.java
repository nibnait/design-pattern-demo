package cc.tianbin.pattern.composite.decision_tree.service.logic.impl;

import cc.tianbin.pattern.composite.decision_tree.model.dto.DecisionMatterReq;
import cc.tianbin.pattern.composite.decision_tree.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * 性别规则
 * Created by nibnait on 2022/06/01
 */
@Component
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("gender").toString();
    }
    
}
