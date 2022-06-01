package cc.tianbin.pattern.composite.decision_tree.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by nibnait on 2022/06/01
 */
@Getter
@AllArgsConstructor
public enum TreeNodeType {

    BRANCH_NODE(1, "非叶子节点"),
    LEAF_NODE(2, "叶子节点"),
    ;

    private final Integer code;
    private final String description;
}
