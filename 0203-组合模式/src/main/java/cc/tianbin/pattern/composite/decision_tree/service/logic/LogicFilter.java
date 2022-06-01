package cc.tianbin.pattern.composite.decision_tree.service.logic;


import cc.tianbin.pattern.composite.decision_tree.model.dto.DecisionMatterReq;
import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeNodeLine;

import java.util.List;

/**
 * 规则过滤器
 * Created by nibnait on 2022/06/01
 */
public interface LogicFilter {

    /**
     * 逻辑决策器
     * @param matterValue          决策值
     * @param treeNodeLineInfoList 决策节点
     * @return                     下一个节点Id
     */
    Long filter(String matterValue, List<TreeNodeLine> treeNodeLineInfoList);

    /**
     * 获取决策值
     *
     * @param decisionMatter 决策物料
     * @return               决策值
     */
    String matterValue(DecisionMatterReq decisionMatter);

}
