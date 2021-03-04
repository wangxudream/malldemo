package com.kataer.mall.gateway.config;

import com.kataer.mall.common.util.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JwtUtil.class)
public class Config {
}
