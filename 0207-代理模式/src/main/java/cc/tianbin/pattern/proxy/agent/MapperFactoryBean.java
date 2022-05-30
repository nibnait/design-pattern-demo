package cc.tianbin.pattern.proxy.agent;

import io.github.nibnait.common.utils.DataUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by nibnait on 2022/05/31
 */
@Slf4j
@AllArgsConstructor
public class MapperFactoryBean<T> implements FactoryBean {

    /**
     * 想要代理的对象。也就是对应的 dao 接口
     */
    private Class<T> mapperInterface;

    @Override
    public Object getObject() throws Exception {
        // 代理通过 handler 实现
        InvocationHandler handler = (proxy, method, args) -> {
            Select annotation = method.getAnnotation(Select.class);
            log.info("开始查询 SQL: {}", annotation.value().replace("#{uId}", args[0].toString()));
            return DataUtils.format( "查询成功。req: {}, res: userName: Tom, age: 11", args[0]);
        };

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
