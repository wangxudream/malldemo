package com.kataer.mall.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ConfigA.class, ConfigB.class, com.kataer.mall.mbg.config.ConfigC.class})
@Configuration
public class Config {
}
