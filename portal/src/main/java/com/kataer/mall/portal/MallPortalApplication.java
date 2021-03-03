package com.kataer.mall.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @ClassName MallPortalApplication
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/16 20:45
 * @Version V1.0
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.kataer.mall.*")
public class MallPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallPortalApplication.class, args);
    }
}
