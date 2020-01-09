package com.example.kafkasender.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannel {
    String INPUT = "input-binding";

    @Input(INPUT)
    SubscribableChannel input();
}
