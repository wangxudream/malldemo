package com.kataer.mall.demo.test;

import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestApplication {
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
}
