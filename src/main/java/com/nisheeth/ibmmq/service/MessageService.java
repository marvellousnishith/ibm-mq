package com.nisheeth.ibmmq.service;

import java.util.concurrent.TimeUnit;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nisheeth.ibmmq.models.MessageResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class MessageService {

    private static final String DESTINATION = "DEV.QUEUE.1";

    private final JmsTemplate jmsTemplate;

    public void sendMessage(Object message) {
        jmsTemplate.convertAndSend(DESTINATION, message);
    }

//    @Scheduled(fixedRate = 2, timeUnit = TimeUnit.SECONDS)
    public MessageResponse receiveMessage() {
        String message = jmsTemplate.receiveAndConvert(DESTINATION).toString();
        log.info("Message Received: {}", message);
        return MessageResponse.builder().message(message).build();
    }
}
