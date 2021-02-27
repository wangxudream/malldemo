//package com.kataer.mall.common.config;
//
//import lombok.Data;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * 〈redis配置读取〉
// *
// * @author Listlessp
// * @create 2020/11/12 13:19
// */
//@Data
//@AutoConfigureAfter(RedisAutoConfiguration.class)
//@Component("readRedisConfig")
//@ConfigurationProperties(prefix = "spring.redis")
//public class RedisConfigProperties {
//
//    private boolean useMyCluster;
//    private String host;
//    private String port;
//    private String password;
//    private int database = 0;
//
//    private Cluster cluster;
//
//    public static class Cluster {
//        private List<String> nodes;
//
//        public List<String> getNodes() {
//            return nodes;
//        }
//
//        public void setNodes(List<String> nodes) {
//            this.nodes = nodes;
//        }
//    }
//
//    public RedisConfigProperties.Cluster getCluster() {
//        return cluster;
//    }
//
//    public void setCluster(RedisConfigProperties.Cluster cluster) {
//        this.cluster = cluster;
//    }
//}
