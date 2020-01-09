package com.example.kafkasender.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(InputChannel.class)
public class FilingService {
    public static final String EVENT_TYPE_MESSAGE_HEADER = "Event-Type";

    @StreamListener(target = InputChannel.INPUT)
    public void handleMessage(Message<byte[]> message) {
        final String eventType = (String) message.getHeaders().get(EVENT_TYPE_MESSAGE_HEADER);
        String messageString = new String(message.getPayload());
        log.info("New message of type " + eventType + " received: " + messageString);
        try {
            log.error("###############################");
            log.error(new String(message.getPayload()));
            log.error("###############################");
        } catch (Exception e) {
            log.error("Failed to handle event.", e);
        }
    }
}
