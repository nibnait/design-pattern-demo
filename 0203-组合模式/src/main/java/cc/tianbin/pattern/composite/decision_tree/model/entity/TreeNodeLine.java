package cc.tianbin.pattern.composite.decision_tree.model.entity;

import cc.tianbin.pattern.composite.decision_tree.model.enums.RuleLimitType;
import lombok.Data;

/**
 * 决策树 两个节点之间的那条线
 * Created by nibnait on 2022/06/01
 */
@Data
public class TreeNodeLine {

    /**
     * 节点From
     */
    private Long nodeIdFrom;

    /**
     * 节点To
     */
    private Long nodeIdTo;

    /**
     * 限定类型
     */
    private RuleLimitType ruleLimitType;

    /**
     * 限定值
     */
    private String ruleLimitValue;

}
