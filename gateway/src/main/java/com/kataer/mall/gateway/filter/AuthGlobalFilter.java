package com.kataer.mall.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @ClassName AuthGloableFilter
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/24 21:34
 * @Version V1.0
 **/
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    /**
     * 认证信息Http请求头
     */
    private static final String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    private static final String JWT_TOKEN_PREFIX = "Bearer ";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(JWT_TOKEN_HEADER);
        if (StringUtils.isEmpty(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return chain.filter(exchange);
        }

        return null;
    }

    //过滤器的顺序
    @Override
    public int getOrder() {
        return 0;
    }
}
