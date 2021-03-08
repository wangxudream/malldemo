package com.kataer.mall.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName DemoApplication
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/16 20:45
 * @Version V1.0
 **/
@EnableFeignClients
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
