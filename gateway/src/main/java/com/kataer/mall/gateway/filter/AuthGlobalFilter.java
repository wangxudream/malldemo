package com.kataer.mall.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.kataer.mall.common.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


/**
 * @ClassName AuthGloableFilter
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/24 21:34
 * @Version V1.0
 **/
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    /**
     * 认证信息Http请求头
     */
    public static final String LOGIN_TOKEN_KEY = "X-PointsShop-Token";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(LOGIN_TOKEN_KEY);
        if (StringUtils.isEmpty(token)) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            byte[] bytes = JSONObject.toJSONString(ResultBody.unauthorized()).getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response.writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
