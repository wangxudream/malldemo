//package com.kataer.mall.common.util;
//
//import io.jsonwebtoken.*;
//
///**
// * @ClassName JwtUtil
// * @Description: TODO
// * @Author kataer
// * @Date 2021/1/26 22:36
// * @Version V1.0
// **/
//public class JwtUtil {
//    private static final String KEY = "aaaa";
//    private Integer ttl = 300000;
//
//    public static String getToken(String playLoad) {
//        long millis = System.currentTimeMillis();
//        return Jwts.builder().signWith(SignatureAlgorithm.HS256, KEY).setPayload(playLoad).compact();
//    }
//
//
//    public static void parse(String token) {
//        final Jwt parse = Jwts.parser().setSigningKey(KEY).parse(token);
//        System.out.println(parse.getBody());
//    }
//
//    public static void main(String[] args) {
//        String token = getToken("User");
//        System.out.println(token);
//        parse(token);
//    }
//
//}
