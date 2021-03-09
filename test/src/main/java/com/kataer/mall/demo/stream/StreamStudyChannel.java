package com.kataer.mall.demo.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StreamStudyChannel {
    String STREAM_STUDY_INPUT = "stream_study_input";

    String STREAM_STUDY_OUTPUT = "stream_study_output";

    @Input(STREAM_STUDY_INPUT)
    MessageChannel receiveMessage();

    @Output(STREAM_STUDY_OUTPUT)
    MessageChannel sendMessage();

}
