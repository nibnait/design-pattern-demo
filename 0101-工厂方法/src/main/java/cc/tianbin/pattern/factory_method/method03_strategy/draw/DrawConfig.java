package cc.tianbin.pattern.factory_method.method03_strategy.draw;

import cc.tianbin.pattern.factory_method.method03_strategy.bo.Strategy;
import cc.tianbin.pattern.factory_method.method03_strategy.bo.DrawStrategy;
import cc.tianbin.pattern.factory_method.method03_strategy.strategy.DrawAlgorithm;
import io.github.nibnait.common.exception.ClientViewException;
import org.springframework.core.annotation.AnnotationUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nibnait on 2022/05/31
 */
public class DrawConfig {

    @Resource
    private List<DrawAlgorithm> algorithmList;

    private static final Map<DrawStrategy, DrawAlgorithm> map = new HashMap<>();

    @PostConstruct
    public void init() {
        for (DrawAlgorithm drawStrategy : algorithmList) {
            Strategy strategy = AnnotationUtils.findAnnotation(drawStrategy.getClass(), Strategy.class);
            if (null != strategy) {
                map.put(strategy.strategyMode(), drawStrategy);
            }
        }
    }

    public DrawAlgorithm getDrawAlgorithm(Integer code) {
        DrawStrategy drawStrategy = DrawStrategy.getByCode(code);
        DrawAlgorithm drawAlgorithm = map.get(drawStrategy);
        if (drawAlgorithm == null) {
            throw new ClientViewException("不存在的抽奖策略 {}", drawStrategy);
        }
        return drawAlgorithm;
    }

}
