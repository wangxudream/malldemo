package com.kataer.mall.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.kataer.mall.common.ResultBody;
import com.kataer.mall.common.constrant.Constrant;
import com.kataer.mall.common.util.JwtUtil;
import com.kataer.mall.gateway.config.ValidUrlsProperties;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Constants;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;


/**
 * @ClassName AuthGlobalFilter
 * @Description: 认证过滤器
 * @Author kataer
 * @Date 2021/1/24 21:34
 * @Version V1.0
 **/
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {


    @Resource
    private ValidUrlsProperties validUrlsProperties;

    @Resource
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //校验请求路径
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getPath().pathWithinApplication().value();
        //服务是否需要验证签名
        if (checkValidService(url)) {
            //非白名单
            if (!isWhites(url)) {
                String token = exchange.getRequest().getHeaders().getFirst(Constrant.LOGIN_TOKEN_KEY);
                Claims claims = jwtUtil.parseJWT(token);
                if (claims == null) {
                    //发送消息
                    ServerHttpResponse response = exchange.getResponse();
                    response.setStatusCode(HttpStatus.UNAUTHORIZED);
                    byte[] bytes = JSONObject.toJSONString(ResultBody.unauthorized()).getBytes(StandardCharsets.UTF_8);
                    DataBuffer buffer = response.bufferFactory().wrap(bytes);
                    response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                    return response.writeWith(Mono.just(buffer));
                }
            }
        }
        return chain.filter(exchange);
    }

    private boolean checkValidService(String url) {
        return validUrlsProperties.getServices().stream().anyMatch(item -> url.startsWith(item));
    }

    private boolean isWhites(String url) {
        return validUrlsProperties.getWhites().stream().anyMatch(item -> item.equals(url));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
