package cc.tianbin.pattern.composite.decision_tree.service.engine.support;

import cc.tianbin.pattern.composite.decision_tree.model.aggregate.DecisionTreeAggregate;
import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeNode;
import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeNodeLine;
import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeRoot;
import cc.tianbin.pattern.composite.decision_tree.model.enums.RuleLimitType;
import cc.tianbin.pattern.composite.decision_tree.model.enums.TreeNodeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 规则引擎 一些非核心方法
 * Created by nibnait on 2022/06/01
 */
public class EngineSupport extends EngineConfig {

    protected DecisionTreeAggregate queryTreeRuleRich(Long treeId) {
        Map<Long, TreeNode> treeNodeMap = new HashMap<>();

        // 节点：1
        TreeNode treeNode_01 = new TreeNode();
        treeNode_01.setTreeId(10001L);
        treeNode_01.setTreeNodeId(1L);
        treeNode_01.setNodeType(TreeNodeType.BRANCH_NODE);
        treeNode_01.setRuleKey("userGender");
        treeNode_01.setRuleDesc("用户性别[男/女]");
        treeNode_01.setTreeNodeLineList(buildTreeNode1LinkList());
        treeNodeMap.put(1L, treeNode_01);

        // 节点：11
        TreeNode treeNode_11 = new TreeNode();
        treeNode_11.setTreeId(10001L);
        treeNode_11.setTreeNodeId(11L);
        treeNode_11.setNodeType(TreeNodeType.BRANCH_NODE);
        treeNode_11.setRuleKey("userAge");
        treeNode_11.setRuleDesc("用户年龄");
        treeNode_11.setTreeNodeLineList(buildTreeNode11LinkList());
        treeNodeMap.put(11L, treeNode_11);

        // 节点：12
        TreeNode treeNode_12 = new TreeNode();
        treeNode_12.setTreeId(10001L);
        treeNode_12.setTreeNodeId(12L);
        treeNode_12.setNodeType(TreeNodeType.BRANCH_NODE);
        treeNode_12.setNodeValue(null);
        treeNode_12.setRuleKey("userAge");
        treeNode_12.setRuleDesc("用户年龄");
        treeNode_12.setTreeNodeLineList(buildTreeNode12LinkList());
        treeNodeMap.put(12L, treeNode_12);

        // 节点：111
        TreeNode treeNode_111 = new TreeNode();
        treeNode_111.setTreeId(10001L);
        treeNode_111.setTreeNodeId(111L);
        treeNode_111.setNodeType(TreeNodeType.LEAF_NODE);
        treeNode_111.setNodeValue("果实A");
        treeNodeMap.put(111L, treeNode_111);

        // 节点：112
        TreeNode treeNode_112 = new TreeNode();
        treeNode_112.setTreeId(10001L);
        treeNode_112.setTreeNodeId(112L);
        treeNode_112.setNodeType(TreeNodeType.LEAF_NODE);
        treeNode_112.setNodeValue("果实B");
        treeNodeMap.put(112L, treeNode_112);

        // 节点：121
        TreeNode treeNode_121 = new TreeNode();
        treeNode_121.setTreeId(10001L);
        treeNode_121.setTreeNodeId(121L);
        treeNode_121.setNodeType(TreeNodeType.LEAF_NODE);
        treeNode_121.setNodeValue("果实C");
        treeNodeMap.put(121L, treeNode_121);

        // 节点：122
        TreeNode treeNode_122 = new TreeNode();
        treeNode_122.setTreeId(10001L);
        treeNode_122.setTreeNodeId(122L);
        treeNode_122.setNodeType(TreeNodeType.LEAF_NODE);
        treeNode_122.setNodeValue("果实D");
        treeNodeMap.put(122L, treeNode_122);

        // 树根
        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(10001L);
        treeRoot.setTreeRootNodeId(1L);
        treeRoot.setTreeName("规则决策树");

        DecisionTreeAggregate decisionTreeAggregate = new DecisionTreeAggregate();
        decisionTreeAggregate.setAggregateRoot(treeRoot);
        decisionTreeAggregate.setTreeNodeMap(treeNodeMap);
        return decisionTreeAggregate;
    }

    private List<TreeNodeLine> buildTreeNode12LinkList() {
        // 链接：12->121
        TreeNodeLine treeNodeLine_121 = new TreeNodeLine();
        treeNodeLine_121.setNodeIdFrom(12L);
        treeNodeLine_121.setNodeIdTo(121L);
        treeNodeLine_121.setRuleLimitType(RuleLimitType.LT);
        treeNodeLine_121.setRuleLimitValue("25");

        // 链接：12->122
        TreeNodeLine treeNodeLine_122 = new TreeNodeLine();
        treeNodeLine_122.setNodeIdFrom(12L);
        treeNodeLine_122.setNodeIdTo(122L);
        treeNodeLine_122.setRuleLimitType(RuleLimitType.GTE);
        treeNodeLine_122.setRuleLimitValue("25");

        List<TreeNodeLine> treeNodeLineList_12 = new ArrayList<>();
        treeNodeLineList_12.add(treeNodeLine_121);
        treeNodeLineList_12.add(treeNodeLine_122);
        return treeNodeLineList_12;
    }

    private List<TreeNodeLine> buildTreeNode11LinkList() {
        // 链接：11->111
        TreeNodeLine treeNodeLine_111 = new TreeNodeLine();
        treeNodeLine_111.setNodeIdFrom(11L);
        treeNodeLine_111.setNodeIdTo(111L);
        treeNodeLine_111.setRuleLimitType(RuleLimitType.LT);
        treeNodeLine_111.setRuleLimitValue("25");

        // 链接：11->112
        TreeNodeLine treeNodeLine_112 = new TreeNodeLine();
        treeNodeLine_112.setNodeIdFrom(11L);
        treeNodeLine_112.setNodeIdTo(112L);
        treeNodeLine_112.setRuleLimitType(RuleLimitType.GTE);
        treeNodeLine_112.setRuleLimitValue("25");

        List<TreeNodeLine> treeNodeLineList_11 = new ArrayList<>();
        treeNodeLineList_11.add(treeNodeLine_111);
        treeNodeLineList_11.add(treeNodeLine_112);
        return treeNodeLineList_11;
    }

    private List<TreeNodeLine> buildTreeNode1LinkList() {
        // 链接：1->11
        TreeNodeLine treeNodeLine_11 = new TreeNodeLine();
        treeNodeLine_11.setNodeIdFrom(1L);
        treeNodeLine_11.setNodeIdTo(11L);
        treeNodeLine_11.setRuleLimitType(RuleLimitType.EQUAL);
        treeNodeLine_11.setRuleLimitValue("man");

        // 链接：1->12
        TreeNodeLine treeNodeLine_12 = new TreeNodeLine();
        treeNodeLine_12.setNodeIdFrom(1L);
        treeNodeLine_12.setNodeIdTo(12L);
        treeNodeLine_12.setRuleLimitType(RuleLimitType.EQUAL);
        treeNodeLine_12.setRuleLimitValue("woman");

        List<TreeNodeLine> treeNodeLineList_1 = new ArrayList<>();
        treeNodeLineList_1.add(treeNodeLine_11);
        treeNodeLineList_1.add(treeNodeLine_12);
        return treeNodeLineList_1;
    }

}
