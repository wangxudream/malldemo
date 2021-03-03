package com.kataer.mall.common.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.compression.GzipCompressionCodec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName JwtUtil
 * @Description: TODO
 * @Author kataer
 * @Date 2021/1/26 22:36
 * @Version V1.0
 **/
@Component
@RefreshScope
public class JwtUtil {
    @Value("${jwt.config.key}")
    private String key;
    @Value("${jwt.config.ttl:0}")
    private long ttl;

    //todo roles改成map的形式
    public String createJWT(String subject, String roles) {
        Date now = new Date();
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(subject)
                .setIssuedAt(now)
                .claim("roles", roles);
        if (ttl > 0) {
            jwtBuilder.setExpiration(new Date(now.getTime() + ttl));
        }
        return jwtBuilder.compact();
    }


    public Claims parseJWT(String jwtStr) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwtStr).getBody();
    }

    public static void main(String[] args) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        String jwtStr = Jwts.builder()
                .setIssuedAt(new Date(currentTimeMillis))
                .setNotBefore(new Date(currentTimeMillis + 5000))
                .setIssuer("master")
                .signWith(SignatureAlgorithm.HS256, "test")
                .setSubject("slaver")
                .setExpiration(new Date(currentTimeMillis + 10000))
                .compressWith(new GzipCompressionCodec())
                .setAudience("slave1")
                .claim("name", "zhangsan")
                .compact();
        System.out.println(jwtStr);
        Thread.sleep(6000);
        Jwt jwt = Jwts.parser().setSigningKey("test").parse(jwtStr);
        Header header = jwt.getHeader();
        System.out.println(header);
        Object body = jwt.getBody();
        System.out.println(body);
    }

}
