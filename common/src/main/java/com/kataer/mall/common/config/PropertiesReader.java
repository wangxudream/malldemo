//package com.kataer.mall.common.config;
//
//import io.micrometer.core.instrument.util.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
///**
// * 〈参数读取类〉
// *
// * @author Listlessp
// * @create 2021/1/27 20:43
// */
//@Configuration
//@AutoConfigureAfter(RedissonConfig.class)
//public class PropertiesReader {
//
//    private static Environment env;
//
//    @Autowired
//    public PropertiesReader(Environment env) {
//        PropertiesReader.env = env;
//    }
//
//    public static String getValue(String key) {
//        return env.getProperty(key);
//    }
//
//    public static int getInt(String key, int defaultVal) {
//        String value = env.getProperty(key);
//        if(StringUtils.isNotBlank(value)) {
//            Integer.valueOf(value);
//        }
//        return defaultVal;
//    }
//    public static boolean getBoolean(String key, boolean defaultVal) {
//        String value = env.getProperty(key);
//        if(StringUtils.isNotBlank(value)) {
//            Boolean.valueOf(value);
//        }
//        return defaultVal;
//    }
//}
