package com.kataer.mall.demo.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class StreamStudySender {

    @Autowired
    private StreamStudyChannel streamStudySource;

    public void sendStreamStudy(String message) {
        streamStudySource.sendMessage().send(MessageBuilder.withPayload(message).build(), 1000L);
    }
}
