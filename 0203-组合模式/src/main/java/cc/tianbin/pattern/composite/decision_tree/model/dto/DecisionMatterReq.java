package cc.tianbin.pattern.composite.decision_tree.model.dto;

import lombok.Data;

import java.util.Map;

/**
 * Created by nibnait on 2022/06/01
 */
@Data
public class DecisionMatterReq {

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 决策值
     */
    private Map<String, Object> valMap;

}
