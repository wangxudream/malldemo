package com.kataer.mall.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class ConfigA {
    @Value("${test.test}")
    private String str;

    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }

    @Bean(value = "aInnerClass")
    public InnerClass innerClass() {
        System.out.println(str);
        System.out.println("ConfigA_InnerClass");
        return new InnerClass();
    }

    public static class InnerClass {
    }
}
