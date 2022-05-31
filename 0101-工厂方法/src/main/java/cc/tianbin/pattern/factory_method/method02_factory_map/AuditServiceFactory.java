package cc.tianbin.pattern.factory_method.method02_factory_map;

import cc.tianbin.pattern.ApplicationContextHelper;
import cc.tianbin.pattern.factory_method.method02_factory_map.bo.OpType;
import cc.tianbin.pattern.factory_method.method02_factory_map.impl.AuditPassServiceImpl;
import cc.tianbin.pattern.factory_method.method02_factory_map.impl.AuditRejectServiceImpl;
import cc.tianbin.pattern.factory_method.method02_factory_map.impl.AuditSpecialPassServiceImpl;
import com.google.common.collect.ImmutableMap;
import io.github.nibnait.common.exception.ServiceException;

import java.util.Map;

/**
 * Created by nibnait on 2022/05/31
 */
public class AuditServiceFactory {

    private static final Map<OpType, AuditService> AUDIT_SERVICE_MAP = ImmutableMap.of(
            OpType.AUDIT_PASS, ApplicationContextHelper.getBean(AuditPassServiceImpl.class),
            OpType.AUDIT_REJECT, ApplicationContextHelper.getBean(AuditRejectServiceImpl.class),
            OpType.SPECIAL_PASS, ApplicationContextHelper.getBean(AuditSpecialPassServiceImpl.class)
    );

    /**
     * auditService 工厂：根据 opType 返回不同的实现
     */
    public static AuditService getAuditService(OpType opType) {
        AuditService auditService = AUDIT_SERVICE_MAP.get(opType);

        if (auditService == null) {
            throw new ServiceException("审核 opType {} 不合法", opType);
        }

        return auditService;
    }
}
