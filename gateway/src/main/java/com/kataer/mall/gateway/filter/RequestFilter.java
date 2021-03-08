package com.kataer.mall.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author kataer
 * @version 1.0
 * @description: TODO 实现鉴权
 * @date 2021/3/3 17:01
 */
@Slf4j
@Component
public class RequestFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        long beginTime = System.currentTimeMillis();
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getPath().pathWithinApplication().value();
        exchange.getAttributes().put("beginTime", beginTime);
        log.info("request time {},path {}", beginTime, url);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -10;
    }
}
