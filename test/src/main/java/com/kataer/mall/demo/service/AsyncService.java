package com.kataer.mall.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@EnableAsync
@Service
public class AsyncService {

    @Async(value = "sysAsycExecutor")
    public void testNormalMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testStaticMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
