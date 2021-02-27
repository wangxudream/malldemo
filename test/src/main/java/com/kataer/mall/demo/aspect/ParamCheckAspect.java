package com.kataer.mall.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ParamCheckAspect {

    @Pointcut("@annotation(com.kataer.mall.demo.aspect.ParamCheck)")
    public void check() {
    }

    @Before("check()")
    public void before() {
        log.info("参数校验Before()");
    }

    @After("check()")
    public void after() {
        log.info("参数校验After()");
    }


    @AfterThrowing("check()")
    public void afterThrowing() {
        log.info("参数校验AfterThrowing()");
    }


    @AfterReturning("check()")
    public void afterReturning() {
        log.info("参数校验AfterReturning()");
    }


    @Around("check()")
    public void around(ProceedingJoinPoint pjp) {
        log.info("参数校验around()-1");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            if (arg == null) {
                throw new RuntimeException();
            }
        }
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            log.error("执行方法失败");
        }
        log.info("参数校验around()-2");
    }
}
