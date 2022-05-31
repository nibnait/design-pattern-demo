package cc.tianbin.pattern.factory_method.method02_factory_map.impl;

import cc.tianbin.pattern.factory_method.method02_factory_map.AuditService;
import cc.tianbin.pattern.factory_method.method02_factory_map.bo.ItemsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by nibnait on 2022/05/31
 */
@Service
@Slf4j
public class AuditSpecialPassServiceImpl implements AuditService {


    @Override
    public int audit(ItemsEntity itemsEntity) {

        log.info("特批通过 执行完毕");

        return 1;
    }
}
