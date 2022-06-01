package cc.tianbin.pattern.composite.decision_tree.model.aggregate;

import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeNode;
import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeRoot;
import cc.tianbin.pattern.domain.support.entity.Aggregate;
import lombok.Data;

import java.util.Map;

/**
 * 决策树 聚合根
 * Created by nibnait on 2022/06/01
 */
@Data
public class DecisionTreeAggregate extends Aggregate<Long, TreeRoot> {

    /**
     * 这棵树下的所有节点
     */
    private Map<Long, TreeNode> treeNodeMap;


}
