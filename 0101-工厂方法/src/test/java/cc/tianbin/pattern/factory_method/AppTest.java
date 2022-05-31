package cc.tianbin.pattern.factory_method;

import cc.tianbin.pattern.Application;
import cc.tianbin.pattern.factory_method.method01_config_map.OpenTailMoneyValidator;
import cc.tianbin.pattern.factory_method.method01_config_map.bo.OpenTailMoneyCheckBO;
import cc.tianbin.pattern.factory_method.method02_factory_map.AuditServiceFactory;
import cc.tianbin.pattern.factory_method.method02_factory_map.bo.ItemsEntity;
import cc.tianbin.pattern.factory_method.method03_strategy_annotation.draw.DrawExec;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by nibnait on 2022/05/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootConfiguration
@Slf4j
public class AppTest {

    @Resource
    private OpenTailMoneyValidator openTailMoneyValidator;
    @Resource
    private DrawExec drawExec;

    @Test
    public void method03() {
        log.info("=== method03 单项概率 抽奖 ===");
        String rewardId = drawExec.doDrawExec(1);
        log.info("奖品id: {}", rewardId);

        log.info("=== method03 总体概率 抽奖 ===");
        rewardId = drawExec.doDrawExec(2);
        log.info("奖品id: {}", rewardId);
    }

    @Test
    public void method02() {
        log.info("=== method02 auditPass ===");
        ItemsEntity auditPass = ItemsEntity.buildAuditPass();
        AuditServiceFactory.getAuditService(auditPass.getOpType()).audit(auditPass);

        log.info("=== method02 auditReject ===");
        ItemsEntity auditReject = ItemsEntity.buildAuditReject();
        AuditServiceFactory.getAuditService(auditReject.getOpType()).audit(auditReject);

        log.info("=== method02 specialPass ===");
        ItemsEntity specialPass = ItemsEntity.buildAuditSpecialPass();
        AuditServiceFactory.getAuditService(specialPass.getOpType()).audit(specialPass);
    }

    @Test
    public void method01() {
        log.info("=== method01 BILI ===");
        openTailMoneyValidator.check(OpenTailMoneyCheckBO.buildBiliChannel());

        log.info("=== method01 TAO ===");
        openTailMoneyValidator.check(OpenTailMoneyCheckBO.buildTaoChannel());

        log.info("=== method01 BILI_TAO ===");
        openTailMoneyValidator.check(OpenTailMoneyCheckBO.buildBiliTaoChannel());
    }

}
