package cc.tianbin.pattern.factory_method.method04_template;

import cc.tianbin.pattern.ApplicationContextHelper;
import cc.tianbin.pattern.factory_method.method04_template.bo.StockOpReq;
import cc.tianbin.pattern.factory_method.method04_template.bo.StockOpRes;
import com.google.common.collect.Lists;
import io.github.nibnait.common.exception.ClientViewException;
import io.github.nibnait.common.utils.DataUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by nibnait on 2022/05/31
 */
@Component
public class StockOpStrategy {

    private Map<Integer, AbstractStockOpStrategy> strategyRouterTable = new HashMap();

    @PostConstruct
    public void init() {
        Map<String, AbstractStockOpStrategy> stockOpStrategyMap = ApplicationContextHelper.getBeansOfType(AbstractStockOpStrategy.class);
        List<AbstractStockOpStrategy> stockOpStrategies = Lists.newArrayList(stockOpStrategyMap.values());
        List<AbstractStockOpStrategy> duplicateElements = DataUtils.getDuplicateElements(stockOpStrategies);
        if (CollectionUtils.isNotEmpty(duplicateElements)) {
            throw new ClientViewException("AbstractStockOpStrategy opType {} 重复");
        }

        strategyRouterTable = stockOpStrategies.stream().collect(Collectors.toMap(AbstractStockOpStrategy::getOpType, router -> router));
    }

    /**
     * 执行库存操作
     */
    public StockOpRes execute(StockOpReq stockOpReq) {

        return strategyRouterTable.get(stockOpReq.getOpType()).execute();
    }

}
