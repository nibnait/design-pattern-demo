package cc.tianbin.pattern.composite.decision_tree.service.engine;

import cc.tianbin.pattern.composite.decision_tree.model.aggregate.DecisionTreeAggregate;
import cc.tianbin.pattern.composite.decision_tree.model.dto.DecisionMatterReq;
import cc.tianbin.pattern.composite.decision_tree.model.dto.EngineResult;
import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeNode;
import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeRoot;
import cc.tianbin.pattern.composite.decision_tree.model.enums.TreeNodeType;
import cc.tianbin.pattern.composite.decision_tree.service.engine.support.EngineSupport;
import cc.tianbin.pattern.composite.decision_tree.service.logic.LogicFilter;
import io.github.nibnait.common.exception.ClientViewException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 规则过滤器引擎
 * Created by nibnait on 2022/06/01
 */
@Component
@Slf4j
public class TreeEngineHandle extends EngineSupport {

    public EngineResult process(DecisionMatterReq matter) {
        // 构造决策规则树
        DecisionTreeAggregate decisionTreeAggregate = queryTreeRuleRich(matter.getTreeId());
        if (null == decisionTreeAggregate) {
            throw new ClientViewException("Tree Rule is null!");
        }

        // 决策节点
        TreeNode treeNodeInfo = engineDecisionMaker(decisionTreeAggregate, matter);

        // 决策结果
        return EngineResult.buildByTreeNode(matter.getTreeId(), treeNodeInfo);
    }

    protected TreeNode engineDecisionMaker(DecisionTreeAggregate treeRuleRich, DecisionMatterReq matter) {
        TreeRoot treeRoot = treeRuleRich.getAggregateRoot();
        Map<Long, TreeNode> treeNodeMap = treeRuleRich.getTreeNodeMap();

        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);

        // 节点类型[NodeType]；1子叶、2果实
        while (TreeNodeType.BRANCH_NODE.equals(treeNodeInfo.getNodeType())) {
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(matter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLineList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            log.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), matter.getUserId(), matter.getTreeId(), treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }

        return treeNodeInfo;
    }
}
