package cc.tianbin.pattern.proxy.agent;

import java.lang.annotation.*;

/**
 * Created by nibnait on 2022/05/31
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {

    String value() default "";

}
