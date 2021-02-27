package com.kataer.mall.mbg.config;

public class ConfigC {
    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
