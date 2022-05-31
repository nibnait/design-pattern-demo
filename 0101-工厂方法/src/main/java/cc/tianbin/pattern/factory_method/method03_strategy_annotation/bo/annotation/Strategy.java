package cc.tianbin.pattern.factory_method.method03_strategy_annotation.bo.annotation;

import cc.tianbin.pattern.factory_method.method03_strategy_annotation.bo.enums.DrawStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Strategy {

    DrawStrategy strategyMode();

}
