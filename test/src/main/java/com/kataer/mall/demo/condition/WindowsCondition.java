package com.kataer.mall.demo.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author kataer
 * @version 1.0
 * @description: 实现Condition接口，返回true则会生成对象
 * @date 2021/3/4 15:15
 */
@Slf4j
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        log.info("操作系统:{}", property);
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
