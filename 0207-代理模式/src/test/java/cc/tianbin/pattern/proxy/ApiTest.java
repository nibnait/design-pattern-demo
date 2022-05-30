package cc.tianbin.pattern.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by nibnait on 2022/05/31
 */
@Slf4j
public class ApiTest {

    @Test
    public void testUserDao() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = beanFactory.getBean("userDao", UserDao.class);
        String res = userDao.queryUserInfo("100001");
        log.info("测试结果：{}", res);
    }

}
