package com.kataer.mall.demo.primary;

import org.springframework.stereotype.Component;


@Component
public class Cat implements Pet {
    @Override
    public void sayHello() {
        System.out.println("Cat");
    }
}
