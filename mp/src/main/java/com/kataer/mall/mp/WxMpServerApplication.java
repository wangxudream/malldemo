package com.kataer.mall.mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微信公众号后台服务
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WxMpServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxMpServerApplication.class, args);
    }
}
