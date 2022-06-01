package cc.tianbin.pattern.composite.decision_tree.service.engine.support;

import cc.tianbin.pattern.composite.decision_tree.service.logic.LogicFilter;
import cc.tianbin.pattern.composite.decision_tree.service.logic.impl.UserAgeFilter;
import cc.tianbin.pattern.composite.decision_tree.service.logic.impl.UserGenderFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 规则配置
 * Created by nibnait on 2022/06/01
 */
public class EngineConfig {

    protected static Map<String, LogicFilter> logicFilterMap = new ConcurrentHashMap<>();

    @Resource
    private UserAgeFilter userAgeFilter;
    @Resource
    private UserGenderFilter userGenderFilter;

    @PostConstruct
    public void init() {
        logicFilterMap.put("userAge", userAgeFilter);
        logicFilterMap.put("userGender", userGenderFilter);
    }

}
