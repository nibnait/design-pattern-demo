package cc.tianbin.pattern.factory_method.method02_factory_map.bo;

import lombok.Data;

/**
 * Created by nibnait on 2022/05/31
 */
@Data
public class ItemsEntity {

    private OpType opType;

    public ItemsEntity(OpType opType) {
        this.opType = opType;
    }

    public static ItemsEntity buildAuditPass() {
        return new ItemsEntity(OpType.AUDIT_PASS);
    }

    public static ItemsEntity buildAuditReject() {
        return new ItemsEntity(OpType.AUDIT_REJECT);
    }

    public static ItemsEntity buildAuditSpecialPass() {
        return new ItemsEntity(OpType.SPECIAL_PASS);
    }
}
