package com.test;

import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestApplication {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Autowired
    private RedissonClient redissonClient;

    private static ConnectionPool connectionPool;

    static {
        connectionPool = new ConnectionPool(5, 60, TimeUnit.SECONDS);
    }

    @Test
    public void testOkHttp() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://www.baidu.com/").build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    @Test
    public void testOkHttp2() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        OkHttpClient client = new OkHttpClient.Builder().connectionPool(connectionPool).build();
        Request request = new Request.Builder().url("https://www.baidu.com/").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                System.out.println("请求失败了!");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(Thread.currentThread().getName() + "请求成功!");
                latch.countDown();
            }
        });

        latch.await();
    }


    @Test
    public void testRedis() {
        System.out.println("template>>>>>>>>>>>>>" + redisTemplate);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            redisTemplate.opsForSet().add("set", i + "");
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }

    @Test
    public void sRandMember() {
        SetOperations<String, String> opsForSet = redisTemplate.opsForSet();
        String set = opsForSet.randomMember("set");
        List<String> strings = opsForSet.randomMembers("set", 5);
        System.out.println(set);
    }

    @Test
    public void testLua() {
        List<String> keyList = new ArrayList();
        keyList.add("kkkkkk");
        String[] arg = new String[2];
        arg[0] = "000";
        arg[1] = "kkk";
        DefaultRedisScript<List> script = new DefaultRedisScript();
        script.setScriptText("local res = ARGV[2]; local kkk = KEYS[1]; redis.call('set',kkk,res); return 'success'");
        List execute = redisTemplate.execute(script, keyList, arg);
        System.out.println(execute);
    }

}
