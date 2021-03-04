package com.kataer.mall.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "valid-urls")
public class ValidUrlsProperties {
    private List<String> services = new ArrayList<>();
    private List<String> whites = new ArrayList<>();
    private List<String> whiteIpAddress = new ArrayList<>();
}
