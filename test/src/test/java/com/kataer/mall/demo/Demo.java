package com.kataer.mall.demo;

import org.springframework.stereotype.Component;

@Component
public class Demo {
    public Demo() {
        System.out.println("测试自动加载com.kataer.mall.demo.Demo");
    }
}
