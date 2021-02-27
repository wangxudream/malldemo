package com.kataer.mall.demo.config;

import org.springframework.context.annotation.Bean;

public class ConfigB {
    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }

    @Bean(value = "bInnerClass")
    public InnerClass innerClass() {
        System.out.println("ConfigB_InnerClass");
        return new InnerClass();
    }

    public static class InnerClass {
        public void sayName() {
            System.out.println("ConfigB_InnerClass");
        }
    }
}
