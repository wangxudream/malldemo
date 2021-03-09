package com.kataer.mall.demo.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Dog implements Pet {
    @Override
    public void sayHello() {
        System.out.println("Dog");
    }
}
