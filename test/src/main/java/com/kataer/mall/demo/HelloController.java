package com.kataer.mall.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/24 12:20
 * @Version V1.0
 **/
@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println(">>>>>>>>>>>>>>>>");
        return "sayHello";
    }

    @GetMapping("/hi")
    public String sayHi() {
        System.out.println(">>>>>>>>>>>>>>>>");
        return "sayHi";
    }
}
