package cc.tianbin.pattern.composite;

import cc.tianbin.pattern.Application;
import cc.tianbin.pattern.composite.decision_tree.model.dto.DecisionMatterReq;
import cc.tianbin.pattern.composite.decision_tree.model.dto.EngineResult;
import cc.tianbin.pattern.composite.decision_tree.service.engine.TreeEngineHandle;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by nibnait on 2022/06/01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class DecisionTreeTest {

    @Resource
    private TreeEngineHandle treeEngineHandle;

    @Test
    public void test() {
        /**
         * 测试数据
         * 果实A：gender=man、age=22
         * 果实B：gender=man、age=29
         * 果实C：gender=woman、age=22
         * 果实D：gender=woman、age=29
         */
        ImmutableMap<String, Object> fruitA = ImmutableMap.of(
                "gender", "man",
                "age", "22"
        );

        DecisionMatterReq decisionMatterReq = new DecisionMatterReq();
        decisionMatterReq.setTreeId(10001L);
        decisionMatterReq.setUserId("Oli09pLkdjh");
        decisionMatterReq.setValMap(fruitA);
        EngineResult result = treeEngineHandle.process(decisionMatterReq);
        log.info("测试结果：{}", JSON.toJSONString(result));
    }

}
