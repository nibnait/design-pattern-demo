package cc.tianbin.pattern.proxy.agent;

import cc.tianbin.pattern.proxy.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Created by nibnait on 2022/05/31
 */
public class RegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(MapperFactoryBean.class);
        beanDefinition.setScope("singleton");
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserDao.class);

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "userDao");
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, beanDefinitionRegistry);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // left
    }
}
