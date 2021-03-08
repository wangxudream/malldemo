package com.kataer.mall.portal.config;

import com.kataer.mall.common.config.RedisConfigProperties;
import com.kataer.mall.common.config.RedissonConfig;
import com.kataer.mall.common.mybatisplus.MpMetaObjectHandler;
import com.kataer.mall.common.mybatisplus.MyBatisPlusConfig;
import com.kataer.mall.common.util.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Import({MyBatisPlusConfig.class, MpMetaObjectHandler.class, RedisConfigProperties.class, RedissonConfig.class, JwtUtil.class})
@Configuration
@EnableSwagger2
public class Config {
}
