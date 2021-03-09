package com.kataer.mall.demo.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;

@Slf4j
@EnableBinding(value = StreamStudyChannel.class)
public class StreamStudyListener {
//    @StreamListener(value = StreamStudyChannel.STREAM_STUDY_INPUT)
//    public void receive(Message<String> message,
//                        @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment) {
//        log.info("接收消息  ：" + message);
//        log.info("接收消息  : " + message.getPayload());
//        String[] strings = message.getPayload().split("_");
//        if (Integer.valueOf(strings[1]) % 2 == 0) {
//            log.info("拒接接收消息  ：" + message.getPayload());
//            acknowledgment.acknowledge();
//
//        }
//    }

    @StreamListener(value = StreamStudyChannel.STREAM_STUDY_INPUT)
    public void receive(Message<String> message) {
        log.info("接收消息  ：" + message);
        log.info("接收消息  : " + message.getPayload());
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
