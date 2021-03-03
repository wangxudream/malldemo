package com.kataer.mall.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.List;


public class RedissonConfig {

    @Resource
    private RedisConfigProperties readRedisConfig;

    @Bean
    public RedissonClient redissonClient() {
        org.redisson.config.Config config = new org.redisson.config.Config();
        if (readRedisConfig.isUseMyCluster()) {
            List<String> nodes = readRedisConfig.getCluster().getNodes();
            String[] nodeAddress = new String[nodes.size()];
            for (int i = 0; i < nodes.size(); i++) {
                nodeAddress[i] = "redis://" + nodes.get(i);
            }
            config.useClusterServers()
                    .setScanInterval(2000)
                    .addNodeAddress(nodeAddress);
        } else {
            config.useSingleServer()
                    .setTimeout(5000) // 命令等待超时，单位：毫秒
                    .setIdleConnectionTimeout(10000) // 连接空闲超时，单位：毫秒
                    .setConnectTimeout(10000) // 接超时，单位：毫秒
                    // 命令失败重试次数,如果尝试达到 retryAttempts（命令失败重试次数） 仍然不能将命令发送至某个指定的节点时，将抛出错误。
                    // 如果尝试在此限制之内发送成功，则开始启用 timeout（命令等待超时） 计时。
                    .setRetryAttempts(3)
                    .setRetryInterval(1500) // 命令重试发送时间间隔，单位：毫秒
                    .setDatabase(readRedisConfig.getDatabase())
                    .setAddress("redis://" + readRedisConfig.getHost() + ":" + readRedisConfig.getPort())
                    .setPassword(readRedisConfig.getPassword());
        }
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
