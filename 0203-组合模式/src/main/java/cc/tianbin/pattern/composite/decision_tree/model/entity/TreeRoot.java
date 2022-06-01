package cc.tianbin.pattern.composite.decision_tree.model.entity;

import cc.tianbin.pattern.domain.support.entity.Entity;
import lombok.Data;

/**
 * 决策树 根节点
 * Created by nibnait on 2022/06/01
 */
@Data
public class TreeRoot implements Entity<Long> {

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 规则树根ID
     */
    private Long treeRootNodeId;

    /**
     * 规则树名称
     */
    private String treeName;

    @Override
    public Long getUniqueId() {
        return treeId;
    }
}
