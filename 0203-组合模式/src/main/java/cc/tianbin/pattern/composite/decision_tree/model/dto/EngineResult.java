package cc.tianbin.pattern.composite.decision_tree.model.dto;

import cc.tianbin.pattern.composite.decision_tree.model.entity.TreeNode;
import lombok.Data;

/**
 * Created by nibnait on 2022/06/01
 */
@Data
public class EngineResult {

    /**
     * 执行结果
     */
    private boolean isSuccess;

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 定位到的节点
     */
    private TreeNode treeNode;


    public static EngineResult buildByTreeNode(Long treeId, TreeNode treeNodeInfo) {
        EngineResult engineResult = new EngineResult();
        engineResult.setTreeId(treeId);

        if (treeNodeInfo == null) {
            engineResult.setSuccess(false);
            return engineResult;
        }

        engineResult.setTreeNode(treeNodeInfo);
        return engineResult;
    }
}
