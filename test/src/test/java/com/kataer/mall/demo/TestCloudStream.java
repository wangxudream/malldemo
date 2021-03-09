package com.kataer.mall.demo;

import com.kataer.mall.demo.stream.StreamStudySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = "dev")
public class TestCloudStream {

    @Autowired
    private StreamStudySender streamStudySender;


    @Test
    public void sendMessage() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            streamStudySender.sendStreamStudy("message_" + i);
            Thread.sleep(50);
        }
        Thread.sleep(1000000);
    }

    @Test
    public void receive() throws InterruptedException {
        Thread.sleep(1000000L);
    }


}
