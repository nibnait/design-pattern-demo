package cc.tianbin.pattern.composite.decision_tree.model.entity;

import cc.tianbin.pattern.composite.decision_tree.model.enums.TreeNodeType;
import lombok.Data;

import java.util.List;

/**
 * 决策树的节点信息
 * Created by nibnait on 2022/06/01
 */
@Data
public class TreeNode {

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 规则树节点ID
     */
    private Long treeNodeId;

    /**
     * 节点类型；1非叶子节点 2叶子节点
     */
    private TreeNodeType nodeType;

    /**
     * 节点值
     */
    private String nodeValue;

    /**
     * 规则Key
     */
    private String ruleKey;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 节点链路
     */
    private List<TreeNodeLine> treeNodeLineList;


}
