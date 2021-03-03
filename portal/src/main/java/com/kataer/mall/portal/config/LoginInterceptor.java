package com.kataer.mall.portal.config;

import com.alibaba.fastjson.JSON;
import com.kataer.mall.common.ResultBody;
import com.kataer.mall.common.model.UserVo;
import com.kataer.mall.common.model.UserVoThreadLocal;
import com.kataer.mall.common.util.JwtUtil;
import com.kataer.mall.common.util.StringUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    public static final String LOGIN_TOKEN_KEY = "X-PointsShop-Token";

    @Resource
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(LOGIN_TOKEN_KEY);
        if (StringUtils.isEmpty(token)) {
            log.error("没有携带token,url:{}", request.getRequestURL());
            sendJsonMessage(response, JSON.toJSONString(ResultBody.unauthorized()));
            return false;
        }
        Claims claims = jwtUtil.parseJWT(token);
        if (claims == null) {
            log.error("无效的token:{}", token);
            sendJsonMessage(response, "请登录");
            return false;
        }

        UserVo userVo = JSON.parseObject(claims.get("roles").toString(), UserVo.class);
        userVo.setToken(UUID.randomUUID().toString());
        UserVoThreadLocal.set(userVo);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserVoThreadLocal.remove();
    }

    public void sendJsonMessage(HttpServletResponse response, String message) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(message);
        writer.close();
        response.flushBuffer();
    }
}
