package cc.tianbin.pattern.composite.decision_tree.service.logic;

import cc.tianbin.pattern.composite.decision_tree.model.dto.DecisionMatterReq;
import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeNodeLine;
import io.github.nibnait.common.constants.CommonConstants;

import java.math.BigDecimal;
import java.util.List;

/**
 * 规则基础抽象类
 * Created by nibnait on 2022/06/01
 */
public abstract class BaseLogic implements LogicFilter {

    @Override
    public Long filter(String matterValue, List<TreeNodeLine> treeNodeLineInfoList) {
        for (TreeNodeLine nodeLine : treeNodeLineInfoList) {
            if (decisionLogic(matterValue, nodeLine)) {
                return nodeLine.getNodeIdTo();
            }
        }
        return CommonConstants.LONG_ZERO;
    }

    /**
     * 获取规则比对值
     * @param decisionMatter 决策物料
     * @return 比对值
     */
    @Override
    public abstract String matterValue(DecisionMatterReq decisionMatter);

    private boolean decisionLogic(String matterValue, TreeNodeLine nodeLine) {
        String ruleLimitValue = nodeLine.getRuleLimitValue();
        int compareResult = new BigDecimal(matterValue).compareTo(new BigDecimal(ruleLimitValue));
        
        switch (nodeLine.getRuleLimitType()) {
            case EQUAL:
                return matterValue.equals(ruleLimitValue);
            case GT:
                return compareResult > 0;
            case GTE:
                return compareResult >= 0;
            case LT:
                return compareResult < 0;
            case LTE:
                return compareResult <= 0;
            default:
                return false;
        }
    }

}
